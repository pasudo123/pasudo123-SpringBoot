package edu.pasudo123.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author pasudo123
 * @since 2019-07-03
 * blog: https://pasudo123.tistory.com/
 * email: oraedoa@gmail.com
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message){
        super(message);
    }

}
