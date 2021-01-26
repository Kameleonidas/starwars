package pl.starwars.api

import feign.FeignException
import pl.starwars.api.infrastructure.FeignClientException

trait TestSwapiSamples {

    def samplePage() {
        new PageDto<CharacterDto>(
                count : 1,
                next : null,
                previous : null,
                results : [sampleCharacter()]
        )
    }

    def sampleCharacter() {
        new CharacterDto(
            name: "Luke Skywalker",
            height: "172",
            mass: "77",
            hairColor: "blond",
            skinColor: "fair",
            eyeColor: "blue",
            birthYear: "19BBY",
            gender: "male",
            homeworld: "http://swapi.dev/api/planets/1/",
            starships: [
                "http://swapi.dev/api/starships/12/",
                "http://swapi.dev/api/starships/22/"
            ],
        )
    }

    def sampleHomeworld() {
        new Homeworld(
            name: "Tatooine",
            rotationPeriod: "23",
            orbitalPeriod: "304",
            diameter: "10465",
            climate: "arid",
            gravity: "1 standard",
            terrain: "desert",
            surfaceWater: "1",
            population: "200000"
        )
    }

    def sampleStarship12() {
        new Starship(
            name: "X-wing",
            model: "T-65 X-wing",
            manufacturer: "Incom Corporation",
            costInCredits: "149999",
            length: "12.5",
            maxAtmospheringSpeed: "1050",
            crew: "1",
            passengers: "0",
            cargoCapacity: "110",
            consumables: "1 week",
            hyperdriveRating: "1.0",
            mglt: "100",
            starshipClass: "Starfighter",
        )
    }

    def sampleStarship22() {
        new Starship(
            name: "Imperial shuttle",
            model: "Lambda-class T-4a shuttle",
            manufacturer: "Sienar Fleet Systems",
            costInCredits: "240000",
            length: "20",
            maxAtmospheringSpeed: "850",
            crew: "6",
            passengers: "20",
            cargoCapacity: "80000",
            consumables: "2 months",
            hyperdriveRating: "1.0",
            mglt: "50",
            starshipClass: "Armed government transport",
        )
    }

    def responseNotFound() {
        throw new FeignClientException(404, "")
    }

}
