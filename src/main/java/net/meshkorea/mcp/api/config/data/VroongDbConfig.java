package net.meshkorea.mcp.api.config.data;

import net.meshkorea.mcp.api.McpApiApplication;
import net.meshkorea.platform.core.web.config.data.AbstractDbConfig;
import net.meshkorea.platform.core.web.config.data.VroongDbProperties;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
		basePackageClasses = { McpApiApplication.class },
		includeFilters = @ComponentScan.Filter(VroongDbConfig.VroongData.class),
		entityManagerFactoryRef = VroongDbConfig.ENTITY_MANAGER_FATORY_NAME)
@MapperScan(
		basePackageClasses = { McpApiApplication.class },
		annotationClass = VroongDbConfig.VroongData.class,
		sqlSessionFactoryRef = VroongDbConfig.SQL_SESSION_FACTORY_NAME)
@EnableConfigurationProperties(VroongDbProperties.class)
public class VroongDbConfig extends AbstractDbConfig {

	public static final String DATA_SOURCE_NAME = "vroongDataSource";
	public static final String ENTITY_MANAGER_FATORY_NAME = "vroongEntityManagerFactory";
	public static final String SQL_SESSION_FACTORY_NAME = "vroongSessionFactory";

	@Autowired
	private VroongDbProperties vroongDbProperties;

	@Override
	@Bean(DATA_SOURCE_NAME)
	public DataSource getDataSource() {
		return vroongDbProperties.toAtomikosNonXADataSourceBean();
	}

	@Bean(ENTITY_MANAGER_FATORY_NAME)
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(JpaVendorAdapter jpaVendorAdapter, Properties jpaProperties) {
		McpApiApplication.class.getPackage().toString();
		return super.getEntityManagerFactory(jpaVendorAdapter, jpaProperties, McpApiApplication.class.getPackage().getName());
	}

	@Bean(SQL_SESSION_FACTORY_NAME)
	public SqlSessionFactoryBean getSqlSessionFactoryBean(ApplicationContext applicationContext) throws Exception {
		return super.getSqlSessionFactoryBean(applicationContext);
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public static @interface VroongData {
	}
}
