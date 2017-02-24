package net.meshkorea.mcp.api.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QClientContentStatistic is a Querydsl query type for ClientContentStatistic
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QClientContentStatistic extends EntityPathBase<ClientContentStatistic> {

    private static final long serialVersionUID = -1462680445L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClientContentStatistic clientContentStatistic = new QClientContentStatistic("clientContentStatistic");

    public final QClientContentStatisticId clientContentStatisticId;

    public final DateTimePath<java.sql.Timestamp> updatedDateTime = createDateTime("updatedDateTime", java.sql.Timestamp.class);

    public QClientContentStatistic(String variable) {
        this(ClientContentStatistic.class, forVariable(variable), INITS);
    }

    public QClientContentStatistic(Path<? extends ClientContentStatistic> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QClientContentStatistic(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QClientContentStatistic(PathMetadata<?> metadata, PathInits inits) {
        this(ClientContentStatistic.class, metadata, inits);
    }

    public QClientContentStatistic(Class<? extends ClientContentStatistic> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clientContentStatisticId = inits.isInitialized("clientContentStatisticId") ? new QClientContentStatisticId(forProperty("clientContentStatisticId")) : null;
    }

}

