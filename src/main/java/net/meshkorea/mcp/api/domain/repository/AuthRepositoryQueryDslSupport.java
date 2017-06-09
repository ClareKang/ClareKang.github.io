package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.platform.core.web.config.data.AuthDbConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by reverof on 2017. 6. 9..
 */
public abstract class AuthRepositoryQueryDslSupport extends NoRepositoryQueryDslSupport {

    public AuthRepositoryQueryDslSupport(Class<?> domainClass) {
        super(domainClass);
    }

    @Override
    @PersistenceContext(unitName = AuthDbConfig.ENTITY_MANAGER_FACTORY_NAME)
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
