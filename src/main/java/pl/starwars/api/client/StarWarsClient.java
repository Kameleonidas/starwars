package pl.starwars.api.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.starwars.api.CharacterDto;
import pl.starwars.api.Homeworld;
import pl.starwars.api.PageDto;
import pl.starwars.api.Starship;

@FeignClient(value = "swapiclient", url = "https://swapi.dev/api", configuration = ClientConfig.class, primary = false)
public interface StarWarsClient {

    @GetMapping(value = "/people/?page={pageNumber}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    PageDto<CharacterDto> getPageCharacters(@PathVariable("pageNumber") Long pageNumber);

    @GetMapping(value = "/people/{id}/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    CharacterDto getCharacter(@PathVariable("id") Long id);

    @GetMapping(value = "/planets/{id}/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Homeworld getHomeworld(@PathVariable("id") Long id);

    @GetMapping(value = "/starships/{id}/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Starship getStarship(@PathVariable("id") Long id);

}
