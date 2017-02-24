package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QDistancePricingPolicy is a Querydsl query type for DistancePricingPolicy
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDistancePricingPolicy extends EntityPathBase<DistancePricingPolicy> {

    private static final long serialVersionUID = -755163750L;

    public static final QDistancePricingPolicy distancePricingPolicy = new QDistancePricingPolicy("distancePricingPolicy");

    public final QPricingPolicy _super = new QPricingPolicy(this);

    //inherited
    public final StringPath description = _super.description;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> moneyDecimalScale = createNumber("moneyDecimalScale", Integer.class);

    public final EnumPath<java.math.RoundingMode> moneyRoundingMode = createEnum("moneyRoundingMode", java.math.RoundingMode.class);

    //inherited
    public final StringPath name = _super.name;

    public final ListPath<DistancePricingRange, QDistancePricingRange> ranges = this.<DistancePricingRange, QDistancePricingRange>createList("ranges", DistancePricingRange.class, QDistancePricingRange.class, PathInits.DIRECT2);

    public QDistancePricingPolicy(String variable) {
        super(DistancePricingPolicy.class, forVariable(variable));
    }

    public QDistancePricingPolicy(Path<? extends DistancePricingPolicy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDistancePricingPolicy(PathMetadata<?> metadata) {
        super(DistancePricingPolicy.class, metadata);
    }

}

