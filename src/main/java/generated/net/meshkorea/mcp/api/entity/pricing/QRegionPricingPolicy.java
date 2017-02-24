package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRegionPricingPolicy is a Querydsl query type for RegionPricingPolicy
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRegionPricingPolicy extends EntityPathBase<RegionPricingPolicy> {

    private static final long serialVersionUID = -18486597L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRegionPricingPolicy regionPricingPolicy = new QRegionPricingPolicy("regionPricingPolicy");

    public final QPricingPolicy _super = new QPricingPolicy(this);

    public final BooleanPath adaptToSameGroup = createBoolean("adaptToSameGroup");

    //inherited
    public final StringPath description = _super.description;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public final net.meshkorea.mcp.api.entity.common.QMoney price;

    public final SetPath<PricingRegionGroup, QPricingRegionGroup> pricingRegionGroups = this.<PricingRegionGroup, QPricingRegionGroup>createSet("pricingRegionGroups", PricingRegionGroup.class, QPricingRegionGroup.class, PathInits.DIRECT2);

    public final EnumPath<RegionType> regionType = createEnum("regionType", RegionType.class);

    public QRegionPricingPolicy(String variable) {
        this(RegionPricingPolicy.class, forVariable(variable), INITS);
    }

    public QRegionPricingPolicy(Path<? extends RegionPricingPolicy> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRegionPricingPolicy(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRegionPricingPolicy(PathMetadata<?> metadata, PathInits inits) {
        this(RegionPricingPolicy.class, metadata, inits);
    }

    public QRegionPricingPolicy(Class<? extends RegionPricingPolicy> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.price = inits.isInitialized("price") ? new net.meshkorea.mcp.api.entity.common.QMoney(forProperty("price")) : null;
    }

}

