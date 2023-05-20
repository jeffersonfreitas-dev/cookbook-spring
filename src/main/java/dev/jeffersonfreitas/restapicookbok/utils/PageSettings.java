package dev.jeffersonfreitas.restapicookbok.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;

@Data
@Slf4j
public class PageSettings {

    private int page = 0;
    private int size = 2;
    private String direction = "dsc";
    private String field;

    public Sort buildSort() {
        switch(direction){
            case "dsc":
                return Sort.by(field).descending();
            case "asc":
                return Sort.by(field).ascending();
            default:
                log.warn("Invalid direction provided in PageSettings. Using descending by default");
                return Sort.by(field).descending();
        }
    }
}
