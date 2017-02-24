package net.meshkorea.mcp.api.entity.order;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOrderAddress is a Querydsl query type for OrderAddress
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QOrderAddress extends BeanPath<OrderAddress> {

    private static final long serialVersionUID = 2125345191L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderAddress orderAddress = new QOrderAddress("orderAddress");

    public final StringPath baseAddress = createString("baseAddress");

    public final StringPath bunjiAddress = createString("bunjiAddress");

    public final StringPath bunjiNo = createString("bunjiNo");

    public final StringPath cityDo = createString("cityDo");

    public final StringPath eupMyunDong = createString("eupMyunDong");

    public final StringPath guGun = createString("guGun");

    public final net.meshkorea.mcp.api.entity.common.QLatLng latLng;

    public final StringPath ri = createString("ri");

    public final StringPath roadAddress = createString("roadAddress");

    public final StringPath zipcode = createString("zipcode");

    public QOrderAddress(String variable) {
        this(OrderAddress.class, forVariable(variable), INITS);
    }

    public QOrderAddress(Path<? extends OrderAddress> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrderAddress(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrderAddress(PathMetadata<?> metadata, PathInits inits) {
        this(OrderAddress.class, metadata, inits);
    }

    public QOrderAddress(Class<? extends OrderAddress> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.latLng = inits.isInitialized("latLng") ? new net.meshkorea.mcp.api.entity.common.QLatLng(forProperty("latLng")) : null;
    }

}

