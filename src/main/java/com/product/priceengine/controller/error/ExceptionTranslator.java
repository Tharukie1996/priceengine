package com.product.priceengine.controller.error;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetail processIllegalArgException(final IllegalArgumentException e) {
        return new ErrorDetail("error", e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> processRuntimeException(final Exception ex) {
        ResponseEntity.BodyBuilder builder;
        ErrorDetail errorVM;
        final ResponseStatus responseStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
        if (responseStatus != null) {
            builder = ResponseEntity.status(responseStatus.value());
            errorVM = new ErrorDetail("error." + responseStatus.value().value(), responseStatus.reason());
        } else {
            builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
            errorVM = new ErrorDetail("InternalServerError", "Internal server error");
        }
        return builder.body(errorVM);
    }
}
