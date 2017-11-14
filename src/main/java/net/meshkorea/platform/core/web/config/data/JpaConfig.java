package net.meshkorea.platform.core.web.config.data;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.orm.jpa.hibernate.SpringJtaPlatform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

@Configuration
public class JpaConfig {

	public static final String JPA_PROPERTIES_NAME = "jpaProperties";

	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setGenerateDdl(false);

		return jpaVendorAdapter;
	}

	@Bean(JPA_PROPERTIES_NAME)
	public Properties getJpaProperties(SpringJtaPlatform springJtaPlatform) {
		Properties properties = new Properties();
		properties.put(AvailableSettings.FORMAT_SQL, "true");
		properties.put(AvailableSettings.TRANSACTION_COORDINATOR_STRATEGY, "jta");
		properties.put(AvailableSettings.JTA_PLATFORM, springJtaPlatform);

		return properties;
	}
}
