package net.meshkorea.mcp.api;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class,
    MybatisAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    TransactionAutoConfiguration.class,
    JtaAutoConfiguration.class,
    SecurityAutoConfiguration.class
}, scanBasePackageClasses = {
    McpApiApplication.class
}, scanBasePackages = {
    "com.vroong",
    "com.meshprime",
    "com.sk",
    "net.meshkorea"
})
public class McpApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpApiApplication.class, args);
    }
}
