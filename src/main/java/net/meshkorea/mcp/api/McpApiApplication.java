package net.meshkorea.mcp.api;

import net.meshkorea.mcp.api.domain.repository.UserRepositoryImpl;
import net.meshkorea.platform.core.CoreApplication;
import net.meshkorea.platform.core.web.CoreWebApplication;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class,
    MybatisAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    TransactionAutoConfiguration.class,
    JtaAutoConfiguration.class,
    SecurityAutoConfiguration.class
}, scanBasePackageClasses = {
    CoreApplication.class,
    CoreWebApplication.class,
    McpApiApplication.class
}, scanBasePackages = {
    "com.vroong",
    "com.meshprime",
    "com.sk"
})
public class McpApiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(McpApiApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        UserRepositoryImpl userRepository = ctx.getBean("userRepositoryImpl", UserRepositoryImpl.class);
    }
}
