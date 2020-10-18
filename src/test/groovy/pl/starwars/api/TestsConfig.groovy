package pl.starwars.api

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import pl.starwars.api.client.StarWarsClient
import spock.mock.DetachedMockFactory

@TestConfiguration
class TestsConfig {

    private DetachedMockFactory mockFactory = new DetachedMockFactory()

    @Bean
    @Primary
    StarWarsClient starWarsClient() {
        return mockFactory.Mock(StarWarsClient)
    }

}
