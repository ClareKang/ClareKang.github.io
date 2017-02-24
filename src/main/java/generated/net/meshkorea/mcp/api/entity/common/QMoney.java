package net.meshkorea.mcp.api.entity.common;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMoney is a Querydsl query type for Money
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QMoney extends BeanPath<Money> {

    private static final long serialVersionUID = -1951970882L;

    public static final QMoney money = new QMoney("money");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final SimplePath<java.util.Currency> currency = createSimple("currency", java.util.Currency.class);

    public QMoney(String variable) {
        super(Money.class, forVariable(variable));
    }

    public QMoney(Path<? extends Money> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMoney(PathMetadata<?> metadata) {
        super(Money.class, metadata);
    }

}

