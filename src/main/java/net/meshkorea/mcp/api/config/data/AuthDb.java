package net.meshkorea.mcp.api.config.data;

import net.meshkorea.mcp.api.McpApiApplication;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;
import net.meshkorea.platform.core.web.config.data.AuthDbProperties;
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
import java.util.Properties;

/**
 * Created by sungjae.hong on 2017. 3. 2..
 */
@Configuration
@EnableJpaRepositories(
    basePackageClasses = {McpApiApplication.class},
    includeFilters = @ComponentScan.Filter(AuthDbConfig.AuthData.class),
    entityManagerFactoryRef = AuthDbConfig.ENTITY_MANAGER_FACTORY_NAME)
@MapperScan(
    basePackageClasses = {McpApiApplication.class},
    annotationClass = AuthDbConfig.AuthData.class,
    sqlSessionFactoryRef = AuthDbConfig.SQL_SESSION_FACTORY_NAME)
@EnableConfigurationProperties(AuthDbProperties.class)
public class AuthDb implements AuthDbConfig {

    private static final String LOCATION_PATTERN = "classpath*:mybatis/mapper/**/*.xml";

    @Autowired
    private AuthDbProperties authDbProperties;

    @Override
    @Bean(DATA_SOURCE_NAME)
    public DataSource getDataSource() {
        return authDbProperties.toAtomikosNonXADataSourceBean();
    }

    @Override
    @Bean(ENTITY_MANAGER_FACTORY_NAME)
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(JpaVendorAdapter jpaVendorAdapter, Properties jpaProperties) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(getDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(McpApiApplication.class.getPackage().getName());
        factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setPersistenceUnitName(AuthDbConfig.ENTITY_MANAGER_FACTORY_NAME);

        return factoryBean;
    }

    @Override
    @Bean(SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactoryBean getSqlSessionFactoryBean(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(LOCATION_PATTERN));
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionFactoryBean;
    }

}