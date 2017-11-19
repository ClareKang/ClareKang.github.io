package net.meshkorea.platform.core.web.config.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface MmsDbConfig extends DbConfig {

    static final String DATA_SOURCE_NAME = "mmsDatasource";
    static final String ENTITY_MANAGER_FACTORY_NAME = "mmsEntityManagerFactory";
    static final String SQL_SESSION_FACTORY_NAME = "mmsSessionFactory";

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    static @interface MmsData {
    }
}
