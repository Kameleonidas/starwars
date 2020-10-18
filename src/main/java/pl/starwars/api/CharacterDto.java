package pl.starwars.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {

    public String name;
    public String height;
    public String mass;
    @SerializedName("hair_color")
    public String hairColor;
    @SerializedName("skin_color")
    public String skinColor;
    @SerializedName("eye_color")
    public String eyeColor;
    @SerializedName("birth_year")
    public String birthYear;
    public String gender;
    public String homeworld;
    public List<String> starships;
}
