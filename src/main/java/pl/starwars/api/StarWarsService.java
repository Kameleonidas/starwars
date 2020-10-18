package pl.starwars.api;

import static java.lang.String.format;

import feign.FeignException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.starwars.api.client.StarWarsClient;
import pl.starwars.api.infrastructure.FeignClientException;

@Slf4j
@Component
@RequiredArgsConstructor
public class StarWarsService {

    private final StarWarsClient starWarsClient;

    Page<Object> getPageCharacter(Long page) {

        List<Object> characterList = new ArrayList<>();
        PageDto<CharacterDto> characterPage = getPageCharacters(page);

        for (CharacterDto characterDto : characterPage.results) {
            characterList.add(buildCharacter(characterDto));
        }

        return Page.builder()
            .count(characterPage.count)
            .pages(getPages(characterPage.count))
            .results(characterList)
            .build();
    }

    Character getCharacter(Long id) {
        return buildCharacter(getCharacterDto(id));
    }

    private PageDto<CharacterDto> getPageCharacters(Long pageNumber) {
        PageDto<CharacterDto> pageDto;
        try {
            pageDto = starWarsClient.getPageCharacters(pageNumber);
        } catch (FeignException fe) {
            log.error(format("Page with page number = %s not found", pageNumber));
            throw new FeignClientException(fe.status(), format("Page with page number = %s not found", pageNumber));
        }
        return pageDto;
    }

    private Character buildCharacter(CharacterDto characterDto) {

        return Character.builder()
            .name(characterDto.name)
            .height(characterDto.height)
            .mass(characterDto.mass)
            .hairColor(characterDto.hairColor)
            .skinColor(characterDto.skinColor)
            .eyeColor(characterDto.eyeColor)
            .birthYear(characterDto.birthYear)
            .gender(characterDto.gender)
            .homeworld(getHomeworld(characterDto.getHomeworld()))
            .starships(getListStarship(characterDto.getStarships()))
            .build();
    }

    private CharacterDto getCharacterDto(Long characterId) {
        CharacterDto characterDto;
        try {
            characterDto = starWarsClient.getCharacter(characterId);
        } catch (FeignException fe) {
            log.error(format("Character with id = %s not found", characterId));
            throw new FeignClientException(fe.status(), format("Character with id = %s not found", characterId));
        }
        return characterDto;

    }

    private Homeworld getHomeworld(String homeworldPath) {
        Homeworld homeworld;
        Long homeworldId = getIdFromUrl(homeworldPath);
        try {
            homeworld = starWarsClient.getHomeworld(homeworldId);
        } catch (FeignException fe) {
            log.error(format("Planet with id = %s not found", homeworldId));
            throw new FeignClientException(fe.status(), format("Planet with id = %s not found", homeworldId));
        }

        return homeworld;
    }

    private List<Starship> getListStarship(List<String> listStarshipPath) {

        List<Starship> starships = new LinkedList<>();
        for (String starshipPath : listStarshipPath) {
            Starship starship;
            Long starshipId = getIdFromUrl(starshipPath);
            try {
                starship = starWarsClient.getStarship(getIdFromUrl(starshipPath));
            } catch (FeignException fe) {
                log.error(format("Starship with id = %s not found", starshipId));
                throw new FeignClientException(fe.status(), format("Starship with id = %s not found", starshipId));
            }
            starships.add(starship);
        }
        return starships;
    }


    private Long getIdFromUrl(String url) {
        String numberOnly = url.replaceAll("[^0-9]", "");
        return Long.parseLong(numberOnly);
    }

    private Integer getPages(Integer countCharacter){
        return (int) Math.ceil((double)countCharacter / 10);
    }

}
