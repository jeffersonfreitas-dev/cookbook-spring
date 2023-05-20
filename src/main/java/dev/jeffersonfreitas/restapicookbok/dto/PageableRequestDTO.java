package dev.jeffersonfreitas.restapicookbok.dto;

import dev.jeffersonfreitas.restapicookbok.exceptions.TooManyRequestException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageableRequestDTO {

    private static final Integer DEFAULT_SIZE = 10;
    private static final Integer MAX_PAGE_SIZE = 1000;

    private Integer page;
    private Integer size;
    private String filter;
    private String direction;
    private String sortField;

    public PageableRequestDTO(Integer page, Integer size){
        this.page = setPage(page);
        this.size = setSize(size);
    }

    public PageableRequestDTO(Integer page, Integer size, String direction, String sortField){
        this(page, size);
        this.direction = setDirection(direction).toUpperCase();
        this.sortField = setSortField(sortField);
    }

    public PageableRequestDTO(Integer page, Integer size, String direction, String sortField, String filter){
        this(page, size, direction, sortField);
        this.filter = setFilter(filter);
    }

    private Integer setPage(final Integer page) {
        return page == null ? 0 : page;
    }

    private Integer setSize(final Integer size) {
        if(size != null && size > MAX_PAGE_SIZE)
            throw new TooManyRequestException("A quantidade máxima para exibir por página é " + MAX_PAGE_SIZE);
        return size == null ? DEFAULT_SIZE : size;
    }

    private String setDirection(final String direction){
        return direction == null ? "asc" : direction;
    }

    public String setSortField(final String sortField){
        return sortField == null ? "" : sortField;
    }

    private String setFilter(final String filter){
        return filter == null ? "" : filter;
    }
}
