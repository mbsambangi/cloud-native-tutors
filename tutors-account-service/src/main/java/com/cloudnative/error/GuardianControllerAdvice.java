package com.cloudnative.error;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by msambangi on 10/26/17.
 */

@ControllerAdvice(annotations = RestController.class)
public class GuardianControllerAdvice {

    private final MediaType vndErrorMediaType = MediaType.parseMediaType("application/vnd.error");

    @ExceptionHandler(GuardianNotFoundException.class)
    ResponseEntity<VndErrors> notFoundException(GuardianNotFoundException gne) {
        return this.error(gne, HttpStatus.NOT_FOUND, gne.getGuardianId().toString());
    }

    private <E extends Exception> ResponseEntity<VndErrors> error(E error, HttpStatus httpStatus, String logref) {
        String msg = Optional.of(error.getMessage()).orElse(error.getClass().getSimpleName());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(this.vndErrorMediaType);
        return new ResponseEntity<>(new VndErrors(logref, msg), httpHeaders, httpStatus);
    }
}
