package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPricingPlan is a Querydsl query type for PricingPlan
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPricingPlan extends EntityPathBase<PricingPlan> {

    private static final long serialVersionUID = 151790534L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPricingPlan pricingPlan = new QPricingPlan("pricingPlan");

    public final QFeeDistribution agentFeeDistribution;

    public final QDeliveryClass deliveryClass;

    public final StringPath description = createString("description");

    public final NumberPath<Integer> feeDecimalScale = createNumber("feeDecimalScale", Integer.class);

    public final EnumPath<java.math.RoundingMode> feeRoundingMode = createEnum("feeRoundingMode", java.math.RoundingMode.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QFeeDistribution managementFeeDistribution;

    public final QFeeDistribution monitoringFeeDistribution;

    public final StringPath name = createString("name");

    public final ListPath<PricingPlanPolicyMap, QPricingPlanPolicyMap> pricingPolicyMaps = this.<PricingPlanPolicyMap, QPricingPlanPolicyMap>createList("pricingPolicyMaps", PricingPlanPolicyMap.class, QPricingPlanPolicyMap.class, PathInits.DIRECT2);

    public QPricingPlan(String variable) {
        this(PricingPlan.class, forVariable(variable), INITS);
    }

    public QPricingPlan(Path<? extends PricingPlan> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPricingPlan(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPricingPlan(PathMetadata<?> metadata, PathInits inits) {
        this(PricingPlan.class, metadata, inits);
    }

    public QPricingPlan(Class<? extends PricingPlan> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.agentFeeDistribution = inits.isInitialized("agentFeeDistribution") ? new QFeeDistribution(forProperty("agentFeeDistribution"), inits.get("agentFeeDistribution")) : null;
        this.deliveryClass = inits.isInitialized("deliveryClass") ? new QDeliveryClass(forProperty("deliveryClass")) : null;
        this.managementFeeDistribution = inits.isInitialized("managementFeeDistribution") ? new QFeeDistribution(forProperty("managementFeeDistribution"), inits.get("managementFeeDistribution")) : null;
        this.monitoringFeeDistribution = inits.isInitialized("monitoringFeeDistribution") ? new QFeeDistribution(forProperty("monitoringFeeDistribution"), inits.get("monitoringFeeDistribution")) : null;
    }

}

