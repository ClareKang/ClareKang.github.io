package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.platform.core.web.config.data.MasterDbConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by reverof on 2017. 6. 9..
 */
public abstract class MasterRepositoryQueryDslSupport extends NoRepositoryQueryDslSupport {

    public MasterRepositoryQueryDslSupport(Class<?> domainClass) {
        super(domainClass);
    }

    @Override
    @PersistenceContext(unitName = MasterDbConfig.ENTITY_MANAGER_FACTORY_NAME)
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
