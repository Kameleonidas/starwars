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

    public String name;
    public String model;
    public String manufacturer;
    @SerializedName("cost_in_credits")
    public String costInCredits;
    public String length;
    @SerializedName("max_atmosphering_speed")
    public String maxAtmospheringSpeed;
    public String crew;
    public String passengers;
    @SerializedName("cargo_capacity")
    public String cargoCapacity;
    public String consumables;
    @SerializedName("hyperdrive_rating")
    public String hyperdriveRating;
    @SerializedName("MGLT")
    public String mglt;
    @SerializedName("starship_class")
    public String starshipClass;
}
