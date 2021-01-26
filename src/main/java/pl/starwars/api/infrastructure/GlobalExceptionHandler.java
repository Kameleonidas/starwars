package pl.starwars.api.infrastructure;

import feign.FeignException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ApiErrorResponse handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        return  ApiErrorResponse.builder()
            .status(e.status())
            .message(e.getMessage())
            .build();
    }
}
