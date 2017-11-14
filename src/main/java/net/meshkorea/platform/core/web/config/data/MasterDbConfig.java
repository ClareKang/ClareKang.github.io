package net.meshkorea.platform.core.web.config.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface MasterDbConfig extends DbConfig {

    static final String DATA_SOURCE_NAME = "masterDataSource";
    static final String ENTITY_MANAGER_FACTORY_NAME = "masterEntityManagerFactory";
    static final String SQL_SESSION_FACTORY_NAME = "masterSessionFactory";

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    static @interface MasterData {
    }
}
