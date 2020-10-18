package pl.starwars.api

import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

trait OperatingOnMyApiEndpoints implements EndpointActions {

    ResultActions getCharactersFromPage(Long pageNum) {
        perform(MockMvcRequestBuilders.get("/api/characters?page=${pageNum}"))
    }

    ResultActions getCharacter(long characterId) {
        perform(MockMvcRequestBuilders.get("/api/characters/${characterId}"))
    }

}
