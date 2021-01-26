package pl.starwars.api.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public
class ApiErrorResponse {

    private Integer status;
    private String message;
}
