package com.forkalau.lmsjava.services.middlewares.validationErrors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface IMapValidationError {
    ResponseEntity<?> mapValidationError(BindingResult result);
}
