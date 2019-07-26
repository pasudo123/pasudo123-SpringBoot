package edu.pasudo123.app.exception;

import org.apache.coyote.ErrorState;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by pasudo123 on 2019-07-19
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {

    private final Errors errors;

    public InvalidRequestException(Errors errors){
        super("");
        this.errors = errors;
    }

    public Errors getErrors(){
        return this.errors;
    }

}
