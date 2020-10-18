package pl.starwars.api

import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder

interface EndpointActions {

    def performWithJsonStringContent(MockHttpServletRequestBuilder requestBuilder, String content)

    String performAndReturnAsString(MockHttpServletRequestBuilder requestBuilder)

    ResultActions perform(MockHttpServletRequestBuilder request)

}
