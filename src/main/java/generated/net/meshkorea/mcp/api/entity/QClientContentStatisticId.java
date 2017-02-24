package net.meshkorea.mcp.api.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QClientContentStatisticId is a Querydsl query type for ClientContentStatisticId
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QClientContentStatisticId extends BeanPath<ClientContentStatisticId> {

    private static final long serialVersionUID = -1181599490L;

    public static final QClientContentStatisticId clientContentStatisticId = new QClientContentStatisticId("clientContentStatisticId");

    public final StringPath clientId = createString("clientId");

    public final NumberPath<Integer> contentId = createNumber("contentId", Integer.class);

    public QClientContentStatisticId(String variable) {
        super(ClientContentStatisticId.class, forVariable(variable));
    }

    public QClientContentStatisticId(Path<? extends ClientContentStatisticId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClientContentStatisticId(PathMetadata<?> metadata) {
        super(ClientContentStatisticId.class, metadata);
    }

}

