package net.meshkorea.mcp.api.entity.pricing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDeliveryClass is a Querydsl query type for DeliveryClass
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDeliveryClass extends EntityPathBase<DeliveryClass> {

    private static final long serialVersionUID = 1190968283L;

    public static final QDeliveryClass deliveryClass = new QDeliveryClass("deliveryClass");

    public final StringPath classCode = createString("classCode");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QDeliveryClass(String variable) {
        super(DeliveryClass.class, forVariable(variable));
    }

    public QDeliveryClass(Path<? extends DeliveryClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDeliveryClass(PathMetadata<?> metadata) {
        super(DeliveryClass.class, metadata);
    }

}

