package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFeeDistribution is a Querydsl query type for FeeDistribution
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QFeeDistribution extends BeanPath<FeeDistribution> {

    private static final long serialVersionUID = 1949317473L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFeeDistribution feeDistribution = new QFeeDistribution("feeDistribution");

    public final net.meshkorea.mcp.api.entity.common.QMoney amount;

    public final EnumPath<FeeDistributionPolicy> policy = createEnum("policy", FeeDistributionPolicy.class);

    public final NumberPath<java.math.BigDecimal> ratio = createNumber("ratio", java.math.BigDecimal.class);

    public QFeeDistribution(String variable) {
        this(FeeDistribution.class, forVariable(variable), INITS);
    }

    public QFeeDistribution(Path<? extends FeeDistribution> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFeeDistribution(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFeeDistribution(PathMetadata<?> metadata, PathInits inits) {
        this(FeeDistribution.class, metadata, inits);
    }

    public QFeeDistribution(Class<? extends FeeDistribution> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.amount = inits.isInitialized("amount") ? new net.meshkorea.mcp.api.entity.common.QMoney(forProperty("amount")) : null;
    }

}

