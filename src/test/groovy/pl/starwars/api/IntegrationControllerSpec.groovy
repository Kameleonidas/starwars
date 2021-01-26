package pl.starwars.api

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper
import net.minidev.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import pl.starwars.api.infrastructure.ObjectMapperConfig

@AutoConfigureMockMvc
abstract class IntegrationControllerSpec extends IntegrationSpecification implements EndpointActions {

    @Autowired
    protected MockMvc client
    protected ObjectMapper objectMapper = ObjectMapperConfig.createObjectMapper()

    def performWithJsonStringContent(MockHttpServletRequestBuilder requestBuilder, String content) {
        perform(requestBuilder.contentType(MediaType.APPLICATION_JSON).content(content))
    }

    Object performAndReturnAsJson(MockHttpServletRequestBuilder requestBuilder) {
        return toJson(performAndReturnAsString(requestBuilder))
    }

    String performAndReturnAsString(MockHttpServletRequestBuilder requestBuilder) {
        return perform(requestBuilder).andReturn().response.contentAsString
    }

    ResultActions perform(MockHttpServletRequestBuilder request) {
        return client.perform(request)
    }

    ResultActions performWithJsonContent(MockHttpServletRequestBuilder requestBuilder, content) {
        return performWithJsonStringContent(requestBuilder, asJsonString(content))
    }

    static def toJson(String text) {
        return new JsonSlurper().parseText(text)
    }

    static String extractResponseAsString(ResultActions response) {
        response.andReturn().response.contentAsString
    }

    protected String asJsonString(final obj) {
        try {
            return objectMapper.writeValueAsString(obj)
        } catch (Exception e) {
            throw new RuntimeException(e)
        }
    }
}
