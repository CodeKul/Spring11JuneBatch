package com.codekul.Spring11JuneBatch.jpa.dto.response;

public interface CalculatePagesResponse {
    String getTitle();
    String getAuthor();
    String getIsbn();
    Integer getPages();
    Long getBookId();
}
