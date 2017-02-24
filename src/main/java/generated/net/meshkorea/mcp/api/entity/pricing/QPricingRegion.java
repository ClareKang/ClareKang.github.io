package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPricingRegion is a Querydsl query type for PricingRegion
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QPricingRegion extends BeanPath<PricingRegion> {

    private static final long serialVersionUID = -107213743L;

    public static final QPricingRegion pricingRegion = new QPricingRegion("pricingRegion");

    public final StringPath name = createString("name");

    public QPricingRegion(String variable) {
        super(PricingRegion.class, forVariable(variable));
    }

    public QPricingRegion(Path<? extends PricingRegion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPricingRegion(PathMetadata<?> metadata) {
        super(PricingRegion.class, metadata);
    }

}

