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

    public String name;
    @SerializedName("rotation_period")
    public String rotationPeriod;
    @SerializedName("orbital_period")
    public String orbitalPeriod;
    public String diameter;
    public String climate;
    public String gravity;
    public String terrain;
    @SerializedName("surface_water")
    public String surfaceWater;
    public String population;
}
