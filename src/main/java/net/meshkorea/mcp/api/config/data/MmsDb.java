package net.meshkorea.mcp.api.config.data;

import net.meshkorea.mcp.api.McpApiApplication;
import net.meshkorea.platform.core.web.config.data.MmsDbConfig;
import net.meshkorea.platform.core.web.config.data.MmsDbProperties;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(
    basePackageClasses = {McpApiApplication.class},
    includeFilters = @ComponentScan.Filter({MmsDbConfig.MmsData.class}),
    entityManagerFactoryRef = MmsDbConfig.ENTITY_MANAGER_FACTORY_NAME)
@MapperScan(
    basePackageClasses = {McpApiApplication.class},
    annotationClass = MmsDbConfig.MmsData.class,
    sqlSessionFactoryRef = MmsDbConfig.SQL_SESSION_FACTORY_NAME)
@EnableConfigurationProperties(MmsDbProperties.class)
public class MmsDb implements MmsDbConfig {

    private static final String LOCATION_PATTERN = "classpath*:mybatis/mapper/**/*.xml";

    @Autowired
    private MmsDbProperties mmsDbProperties;

    @Override
    @Bean(DATA_SOURCE_NAME)
    public DataSource getDataSource() {
        return mmsDbProperties.toAtomikosNonXADataSourceBean();
    }

    @Override
    @Bean(ENTITY_MANAGER_FACTORY_NAME)
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(JpaVendorAdapter jpaVendorAdapter, Properties jpaProperties) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(getDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(McpApiApplication.class.getPackage().getName(), Jsr310JpaConverters.class.getPackage().getName());
        factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setPersistenceUnitName(MmsDbConfig.ENTITY_MANAGER_FACTORY_NAME);

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