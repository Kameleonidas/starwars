package pl.starwars.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/characters")
@RequiredArgsConstructor
class StarWarsRestController {

    private final StarWarsService starWarsService;

    @GetMapping
    public Page<Object> getPageCharacter(@RequestParam final Long page) {
        return starWarsService.getPageCharacter(page);
    }

    @GetMapping("/{id}")
    public Character getCharacter(@PathVariable final Long id) {
        return starWarsService.getCharacter(id);
    }
}
