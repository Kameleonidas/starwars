package pl.starwars.api


import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [StarWarsApplication, TestsConfig], webEnvironment = SpringBootTest.WebEnvironment.MOCK)
abstract class IntegrationSpecification extends Specification {

}
