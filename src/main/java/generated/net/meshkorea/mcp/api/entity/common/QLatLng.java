package net.meshkorea.mcp.api.entity.common;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QLatLng is a Querydsl query type for LatLng
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QLatLng extends BeanPath<LatLng> {

    private static final long serialVersionUID = -422959160L;

    public static final QLatLng latLng = new QLatLng("latLng");

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public QLatLng(String variable) {
        super(LatLng.class, forVariable(variable));
    }

    public QLatLng(Path<? extends LatLng> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLatLng(PathMetadata<?> metadata) {
        super(LatLng.class, metadata);
    }

}

