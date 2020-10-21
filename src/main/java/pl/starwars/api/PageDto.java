package pl.starwars.api;

import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> {

    private Integer count;
    private String next;
    private String previous;
    @Builder.Default
    private List<T> results = new LinkedList<>();

}
