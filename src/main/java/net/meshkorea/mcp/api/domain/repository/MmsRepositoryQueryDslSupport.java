package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.platform.core.web.config.data.MmsDbConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by reverof on 2017. 6. 9..
 */
public abstract class MmsRepositoryQueryDslSupport extends NoRepositoryQueryDslSupport {

    public MmsRepositoryQueryDslSupport(Class<?> domainClass) {
        super(domainClass);
    }

    @Override
    @PersistenceContext(unitName = MmsDbConfig.ENTITY_MANAGER_FACTORY_NAME)
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
