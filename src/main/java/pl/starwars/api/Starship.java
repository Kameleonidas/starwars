package pl.starwars.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Starship {

    private String name;
    private String model;
    private String manufacturer;
    @SerializedName("cost_in_credits")
    private String costInCredits;
    private String length;
    @SerializedName("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    @SerializedName("cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @SerializedName("hyperdrive_rating")
    private String hyperdriveRating;
    @SerializedName("MGLT")
    private String mglt;
    @SerializedName("starship_class")
    private String starshipClass;
}
