package net.meshkorea.mcp.api.domain.model.common;

public interface PageableResponse {
    Integer getTotalPages();

    Long getTotalItems();

    Boolean getHasNext();

    Boolean getHasPrevious();
}
