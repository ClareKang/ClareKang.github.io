package net.meshkorea.platform.core.web.config.data;

import com.atomikos.icatch.config.UserTransactionService;
import com.atomikos.icatch.config.UserTransactionServiceImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.boot.ApplicationHome;
import org.springframework.boot.autoconfigure.transaction.jta.JtaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringJtaPlatform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.util.StringUtils;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import java.io.File;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties({ JtaProperties.class, AtomikosProperties.class })
@EnableTransactionManagement
public class TransactionConfig {

	private static final int TRANSACTION_TIMEOUT_SECONDS = 60;

	private final JtaProperties jtaProperties;

	private final AtomikosProperties atomikosProperties;

	public TransactionConfig(JtaProperties jtaProperties, AtomikosProperties atomikosProperties) {
		this.jtaProperties = jtaProperties;
		this.atomikosProperties = atomikosProperties;
	}

	@Bean(initMethod = "init", destroyMethod = "shutdownForce")
	public UserTransactionServiceImp userTransactionService() {
		Properties properties = new Properties();
		if (StringUtils.hasText(this.jtaProperties.getTransactionManagerId())) {
			properties.setProperty("com.atomikos.icatch.tm_unique_name",
					this.jtaProperties.getTransactionManagerId());
		}
		properties.setProperty("com.atomikos.icatch.log_base_dir", getLogBaseDir());
		properties.putAll(atomikosProperties.asProperties());

		return new UserTransactionServiceImp(properties);
	}

	private String getLogBaseDir() {
		if (StringUtils.hasLength(this.jtaProperties.getLogDir())) {
			return this.jtaProperties.getLogDir();
		}
		File home = new ApplicationHome().getDir();
		return new File(home, "transaction-logs").getAbsolutePath();
	}

	@Bean(initMethod = "init", destroyMethod = "close")
	public UserTransactionManager atomikosTransactionManager(UserTransactionService userTransactionService) throws Exception {
		UserTransactionManager manager = new UserTransactionManager();
		manager.setStartupTransactionService(false);
		manager.setForceShutdown(true);
		manager.setTransactionTimeout(TRANSACTION_TIMEOUT_SECONDS);

		return manager;
	}

	@Bean
	public JtaTransactionManager transactionManager(UserTransaction userTransaction, TransactionManager transactionManager) {
		return new JtaTransactionManager(userTransaction, transactionManager);
	}

	@Bean
	public SpringJtaPlatform getAtomikosJtaPlatform(JtaTransactionManager jtaTransactionManager) {
		return new SpringJtaPlatform(jtaTransactionManager);
	}
}
