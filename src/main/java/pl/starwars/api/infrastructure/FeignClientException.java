package pl.starwars.api.infrastructure;

import feign.FeignException;

public class FeignClientException extends FeignException {

    public FeignClientException(int status, String message) {
        super(status, message);
    }

}
