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
public class Page<T> {

    public Integer count;
    public Integer pages;
    @Builder.Default
    public List<T> results = new LinkedList<>();

}
