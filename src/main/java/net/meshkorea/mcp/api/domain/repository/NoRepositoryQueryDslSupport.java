package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.core.dml.DeleteClause;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.PathBuilderFactory;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 * Muti datasource 환경에서 {@link org.springframework.data.jpa.repository.support.QueryDslRepositorySupport} 클래스를 사용할 경우
 * @Primary EntityManager 가 injection 되는 문제가 있어 코드를 그대로 복사해서 이름만 바꾼 클래스
 * 상속하고 반드시 {@link EntityManager} injector 를 구현해야 된다
 * ex)
 * @PersistenceContext(unitName = ENTITY_MANAGER_UNIT_NAME)
 * public void setEntityManager(EntityManager entityManager) {
 *   super.setEntityManager(entityManager);
 * }
 *
 * Created by reverof on 2017. 6. 9..
 */
public abstract class NoRepositoryQueryDslSupport {

    private final PathBuilder<?> builder;

    private EntityManager entityManager;
    private Querydsl querydsl;

    /**
     * Creates a new {@link org.springframework.data.jpa.repository.support.QueryDslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public NoRepositoryQueryDslSupport(Class<?> domainClass) {

        Assert.notNull(domainClass, "Domain class must not be null!");
        this.builder = new PathBuilderFactory().create(domainClass);
    }

    /**
     * Setter to inject {@link EntityManager}.
     *
     * @param entityManager must not be {@literal null}
     */
    public void setEntityManager(EntityManager entityManager) {

        Assert.notNull(entityManager, "EntityManager must not be null!");
        this.querydsl = new Querydsl(entityManager, builder);
        this.entityManager = entityManager;
    }

    /**
     * Callback to verify configuration. Used by containers.
     */
    @PostConstruct
    public void validate() {
        Assert.notNull(entityManager, "EntityManager must not be null!");
        Assert.notNull(querydsl, "Querydsl must not be null!");
    }

    /**
     * Returns the {@link EntityManager}.
     *
     * @return the entityManager
     */
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Returns a fresh {@link JPQLQuery}.
     *
     * @param paths must not be {@literal null}.
     * @return the Querydsl {@link JPQLQuery}.
     */
    protected JPQLQuery<Object> from(EntityPath<?>... paths) {
        return querydsl.createQuery(paths);
    }

    /**
     * Returns a {@link JPQLQuery} for the given {@link EntityPath}.
     *
     * @param path must not be {@literal null}.
     * @return
     */
    protected <T> JPQLQuery<T> from(EntityPath<T> path) {
        return querydsl.createQuery(path).select(path);
    }

    /**
     * Returns a fresh {@link DeleteClause}.
     *
     * @param path
     * @return the Querydsl {@link DeleteClause}.
     */
    protected DeleteClause<JPADeleteClause> delete(EntityPath<?> path) {
        return new JPADeleteClause(entityManager, path);
    }

    /**
     * Returns a fresh {@link UpdateClause}.
     *
     * @param path
     * @return the Querydsl {@link UpdateClause}.
     */
    protected UpdateClause<JPAUpdateClause> update(EntityPath<?> path) {
        return new JPAUpdateClause(entityManager, path);
    }

    /**
     * Returns a {@link PathBuilder} for the configured domain type.
     *
     * @param <T>
     * @return the Querdsl {@link PathBuilder}.
     */
    @SuppressWarnings("unchecked")
    protected <T> PathBuilder<T> getBuilder() {
        return (PathBuilder<T>) builder;
    }

    /**
     * Returns the underlying Querydsl helper instance.
     *
     * @return
     */
    protected Querydsl getQuerydsl() {
        return this.querydsl;
    }
}
