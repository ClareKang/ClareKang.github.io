package net.meshkorea.mcp.api.config.data;

import net.meshkorea.mcp.api.McpApiApplication;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.config.data.MasterDbProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
    includeFilters = @ComponentScan.Filter({MasterDbConfig.MasterData.class}),
    entityManagerFactoryRef = MasterDbConfig.ENTITY_MANAGER_FACTORY_NAME)
@MapperScan(
    basePackageClasses = {McpApiApplication.class},
    annotationClass = MasterDbConfig.MasterData.class,
    sqlSessionFactoryRef = MasterDbConfig.SQL_SESSION_FACTORY_NAME)
@EnableConfigurationProperties(MasterDbProperties.class)
public class MasterDb implements MasterDbConfig {

    private static final String LOCATION_PATTERN = "classpath*:mybatis/mapper/**/*.xml";

    @Autowired
    private MasterDbProperties masterDbProperties;

    @Override
    @Primary
    @Bean(DATA_SOURCE_NAME)
    public DataSource getDataSource() {
        return masterDbProperties.toAtomikosNonXADataSourceBean();
    }

    @Override
    @Primary
    @Bean(ENTITY_MANAGER_FACTORY_NAME)
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(JpaVendorAdapter jpaVendorAdapter, Properties jpaProperties) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(getDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(McpApiApplication.class.getPackage().getName(), Jsr310JpaConverters.class.getPackage().getName());
        factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setPersistenceUnitName(MasterDbConfig.ENTITY_MANAGER_FACTORY_NAME);

        return factoryBean;
    }

    @Override
    @Primary
    @Bean(SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactoryBean getSqlSessionFactoryBean(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(LOCATION_PATTERN));
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate masterSqlSessionTemplate(SqlSessionFactory getSqlSessionFactoryBean) throws Exception {
        getSqlSessionFactoryBean.getConfiguration().setMapUnderscoreToCamelCase(true);
        return new SqlSessionTemplate(getSqlSessionFactoryBean);
    }

}
