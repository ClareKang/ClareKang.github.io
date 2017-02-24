package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPricingRegionGroup is a Querydsl query type for PricingRegionGroup
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPricingRegionGroup extends EntityPathBase<PricingRegionGroup> {

    private static final long serialVersionUID = -1335753554L;

    public static final QPricingRegionGroup pricingRegionGroup = new QPricingRegionGroup("pricingRegionGroup");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<PricingRegion, QPricingRegion> pricingRegions = this.<PricingRegion, QPricingRegion>createSet("pricingRegions", PricingRegion.class, QPricingRegion.class, PathInits.DIRECT2);

    public QPricingRegionGroup(String variable) {
        super(PricingRegionGroup.class, forVariable(variable));
    }

    public QPricingRegionGroup(Path<? extends PricingRegionGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPricingRegionGroup(PathMetadata<?> metadata) {
        super(PricingRegionGroup.class, metadata);
    }

}

