package dev.jeffersonfreitas.restapicookbok.model;

import java.util.List;

public class PageDTO<T> {

    List<T> content;
    long totalElements;
    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
