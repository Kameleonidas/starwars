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

    public Integer count;
    public String next;
    public String previous;
    @Builder.Default
    public List<T> results = new LinkedList<>();

}
