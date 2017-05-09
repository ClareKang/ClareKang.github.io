package net.meshkorea.mcp.api.model.dto;

/**
 * Created by reverof on 2017. 4. 13..
 */
public interface ModelMapper<T, U> {
    T from(U entity);
    U to(U entity);
}
