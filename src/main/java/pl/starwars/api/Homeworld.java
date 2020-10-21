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
public class Homeworld {

    private String name;
    @SerializedName("rotation_period")
    private String rotationPeriod;
    @SerializedName("orbital_period")
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    @SerializedName("surface_water")
    private String surfaceWater;
    private String population;
}
