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
class Page<T> {

    private Integer count;
    private Integer pages;
    @Builder.Default
    private List<T> results = new LinkedList<>();

}
