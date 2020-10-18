package pl.starwars.api

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import pl.starwars.api.client.StarWarsClient
import pl.starwars.api.infrastructure.FeignClientException

class StarWarsRestControllerIT extends IntegrationControllerSpec implements TestSwapiSamples, ResultSample, OperatingOnMyApiEndpoints {

    @Autowired
    private StarWarsClient starWarsClient

    def setup() {
        starWarsClient.getCharacter(1) >> sampleCharacter()
        starWarsClient.getPageCharacters(1) >> samplePage()
        starWarsClient.getHomeworld(_) >> sampleHomeworld()
        starWarsClient.getStarship(12) >> sampleStarship12()
        starWarsClient.getStarship(22) >> sampleStarship22()
        starWarsClient.getCharacter(84) >> {responseNotFound()}
        starWarsClient.getPageCharacters(2) >> {responseNotFound()}
    }

    def "should get character with specify id = 1"() {
        given:
        def characterId = 1

        when:
        def response = getCharacter(characterId)

        then:
        response.andExpect(status().isOk())

        and:
        def expectedCharacterJson = asJsonString(resultCharacter())
        def jsonResponse = extractResponseAsString(response)
        assert jsonResponse == expectedCharacterJson
    }

    def "should get characters from page specify page number = 1"() {
        given:
        def pageNumber = 1

        when:
        def response = getCharactersFromPage(pageNumber)

        then:
        response.andExpect(status().isOk())

        and:
        def jsonResponse = extractResponseAsString(response)
        def expectedPageJson = asJsonString(resultPage())
        assert jsonResponse == expectedPageJson
    }


    def "should not get character with specify id = 84 and throw feign exception"() throws FeignClientException {
        given:
        def characterId = 84

        when:
        def response = getCharacter(characterId)

        then:
        response.andExpect(status().isNotFound())

        and:
        def jsonResponse = extractResponseAsString(response)
        def apiErrorResponse = asJsonString(apiErrorResponseCharacter())
        assert jsonResponse == apiErrorResponse
    }

    def "should not get characters from page specify page number = 2 and throw feign exception"() throws FeignClientException {
        given:
        def pageNumber = 2

        when:
        def response = getCharactersFromPage(pageNumber)

        then:
        response.andExpect(status().isNotFound())

        and:
        def jsonResponse = extractResponseAsString(response)
        def apiErrorResponse = asJsonString(apiErrorResponsePage())
        assert jsonResponse == apiErrorResponse
    }

}