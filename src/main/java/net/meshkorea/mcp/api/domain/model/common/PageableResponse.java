package net.meshkorea.mcp.api.domain.model.common;

public interface PageableResponse {
    Integer getPage();

    Integer getSize();

    Integer getTotalPages();

    Long getTotalItems();
}
