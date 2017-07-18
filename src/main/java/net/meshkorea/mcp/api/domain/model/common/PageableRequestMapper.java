package net.meshkorea.mcp.api.domain.model.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by reverof on 2017-06-13.
 */
public class PageableRequestMapper {

    public static Integer DEFAULT_PAGE = 0;
    public static Integer DEFAULT_SIZE = 10;

    public static PageRequest getPageRequest(PageableRequest pageableRequest) {
        if (pageableRequest.getPage() > -1
            && pageableRequest.getSize() > 0) {
            return new PageRequest(pageableRequest.getPage(), pageableRequest.getSize());
        }
        return new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE);
    }

    public static PageRequest getPageRequest(PageableRequest pageableRequest, Sort sort) {
        Integer page = DEFAULT_PAGE;
        Integer size = DEFAULT_SIZE;
        if (pageableRequest != null) {
            if (pageableRequest.getPage() != null && pageableRequest.getPage() > -1) {
                page = pageableRequest.getPage();
            }
            if (pageableRequest.getSize() != null && pageableRequest.getSize() > 0) {
                size = pageableRequest.getSize();
            }
        }
        return new PageRequest(page, size, sort);
    }

    public static PageRequest getPageRequest(Integer page, Integer size, Sort sort) {
        if (page > -1 && size > 0) {
            return new PageRequest(page, size, sort);
        }
        return new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE, sort);
    }

    public static PageRequest getPageRequest(Integer page, Sort sort) {
        if (page > -1) {
            return new PageRequest(page, DEFAULT_SIZE, sort);
        }
        return new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE, sort);
    }
}
