package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPricingPolicy is a Querydsl query type for PricingPolicy
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPricingPolicy extends EntityPathBase<PricingPolicy> {

    private static final long serialVersionUID = -155088241L;

    public static final QPricingPolicy pricingPolicy = new QPricingPolicy("pricingPolicy");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QPricingPolicy(String variable) {
        super(PricingPolicy.class, forVariable(variable));
    }

    public QPricingPolicy(Path<? extends PricingPolicy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPricingPolicy(PathMetadata<?> metadata) {
        super(PricingPolicy.class, metadata);
    }

}

