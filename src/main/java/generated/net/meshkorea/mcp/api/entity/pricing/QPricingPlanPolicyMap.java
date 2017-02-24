package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPricingPlanPolicyMap is a Querydsl query type for PricingPlanPolicyMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPricingPlanPolicyMap extends EntityPathBase<PricingPlanPolicyMap> {

    private static final long serialVersionUID = -910754396L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPricingPlanPolicyMap pricingPlanPolicyMap = new QPricingPlanPolicyMap("pricingPlanPolicyMap");

    public final StringPath destRegion = createString("destRegion");

    public final EnumPath<RegionType> destRegionType = createEnum("destRegionType", RegionType.class);

    public final StringPath originRegion = createString("originRegion");

    public final EnumPath<RegionType> originRegionType = createEnum("originRegionType", RegionType.class);

    public final QPricingPlan pricingPlan;

    public final QPricingPolicy pricingPolicy;

    public final NumberPath<Integer> priority = createNumber("priority", Integer.class);

    public QPricingPlanPolicyMap(String variable) {
        this(PricingPlanPolicyMap.class, forVariable(variable), INITS);
    }

    public QPricingPlanPolicyMap(Path<? extends PricingPlanPolicyMap> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPricingPlanPolicyMap(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPricingPlanPolicyMap(PathMetadata<?> metadata, PathInits inits) {
        this(PricingPlanPolicyMap.class, metadata, inits);
    }

    public QPricingPlanPolicyMap(Class<? extends PricingPlanPolicyMap> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pricingPlan = inits.isInitialized("pricingPlan") ? new QPricingPlan(forProperty("pricingPlan"), inits.get("pricingPlan")) : null;
        this.pricingPolicy = inits.isInitialized("pricingPolicy") ? new QPricingPolicy(forProperty("pricingPolicy")) : null;
    }

}

