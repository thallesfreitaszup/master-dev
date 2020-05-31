package masterdev.br.com.zup.exception;

import javassist.NotFoundException;
import masterdev.br.com.zup.log.LogGame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {InternalServerErrorException.class})
    protected ResponseEntity<ApiError> handleException(InternalServerErrorException internalServerErrorException) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR,internalServerErrorException);
    }
    @ExceptionHandler(value
            = {BadRequestException.class})
    protected ResponseEntity<ApiError> handleBadRequestException(BadRequestException badRequestException) {
        return error(HttpStatus.BAD_REQUEST,badRequestException);
    }

    @ExceptionHandler(value
            = {NotFoundException.class})
    protected ResponseEntity<ApiError> handleNotFoundException(NotFoundException notFoundException) {
        return error(HttpStatus.NOT_FOUND,notFoundException);
    }

    @ExceptionHandler(value
            = {IllegalArgumentException.class})
    protected ResponseEntity<ApiError> handleNotFoundException(IllegalArgumentException illegalArgumentException) {
        return error(HttpStatus.BAD_REQUEST,illegalArgumentException);
    }

    @ExceptionHandler(value
            = {BadCredentialsException.class})
    protected ResponseEntity<ApiError> handleBadCredentialsException(BadCredentialsException badCredentialsException) {
        return error(HttpStatus.BAD_REQUEST,badCredentialsException);
    }

    private ResponseEntity<ApiError> error(HttpStatus status, Exception exception) {
        ApiError apiError = new ApiError(status,exception.getMessage(),exception);
        new LogGame().error(exception.getMessage());
        return ResponseEntity.status(status).body(apiError);
    }


}
