package OkeyDokey.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class SearchRequest {
    private List<String> clothers;
    private List<String> genders;
    private Integer price = 0;
    private String searchType;
    private String text;
}
