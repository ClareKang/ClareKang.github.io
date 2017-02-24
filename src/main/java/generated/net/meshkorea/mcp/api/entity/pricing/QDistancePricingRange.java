package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QDistancePricingRange is a Querydsl query type for DistancePricingRange
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QDistancePricingRange extends BeanPath<DistancePricingRange> {

    private static final long serialVersionUID = -161475627L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDistancePricingRange distancePricingRange = new QDistancePricingRange("distancePricingRange");

    public final net.meshkorea.mcp.api.entity.common.QMoney baseFee;

    public final NumberPath<Double> distFrom = createNumber("distFrom", Double.class);

    public final NumberPath<Double> distTo = createNumber("distTo", Double.class);

    public final net.meshkorea.mcp.api.entity.common.QMoney pricePerUnit;

    public final NumberPath<Double> unitDist = createNumber("unitDist", Double.class);

    public QDistancePricingRange(String variable) {
        this(DistancePricingRange.class, forVariable(variable), INITS);
    }

    public QDistancePricingRange(Path<? extends DistancePricingRange> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDistancePricingRange(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDistancePricingRange(PathMetadata<?> metadata, PathInits inits) {
        this(DistancePricingRange.class, metadata, inits);
    }

    public QDistancePricingRange(Class<? extends DistancePricingRange> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.baseFee = inits.isInitialized("baseFee") ? new net.meshkorea.mcp.api.entity.common.QMoney(forProperty("baseFee")) : null;
        this.pricePerUnit = inits.isInitialized("pricePerUnit") ? new net.meshkorea.mcp.api.entity.common.QMoney(forProperty("pricePerUnit")) : null;
    }

}

