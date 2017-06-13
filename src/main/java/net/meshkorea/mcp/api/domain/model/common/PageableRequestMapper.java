package net.meshkorea.mcp.api.domain.model.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by reverof on 2017-06-13.
 */
public class PageableRequestMapper {

    public static Integer DEFAULT_SIZE = 10;

    public static PageRequest getPageRequest(PageableRequest pageableRequest) {
        if (pageableRequest.getPage() > -1
            || pageableRequest.getSize() > 0) {
            return new PageRequest(pageableRequest.getPage(), pageableRequest.getSize());
        }
        return new PageRequest(0, DEFAULT_SIZE);
    }

    public static PageRequest getPageRequest(PageableRequest pageableRequest, Sort sort) {
        if (pageableRequest.getPage() > -1
            || pageableRequest.getSize() > 0) {
            return new PageRequest(pageableRequest.getPage(), pageableRequest.getSize(), sort);
        }
        return new PageRequest(0, DEFAULT_SIZE, sort);
    }
}
