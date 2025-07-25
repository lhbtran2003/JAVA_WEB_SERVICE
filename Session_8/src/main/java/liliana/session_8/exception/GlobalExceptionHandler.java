package liliana.session_8.exception;

import liliana.session_8.dto.response.DataError;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DataError> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String,String> details = new HashMap<>();
        ex.getFieldErrors().forEach(error -> details.put(error.getField(), error.getDefaultMessage()));
        DataError dataError = DataError.builder()
                .code(400)
                .message("Validation error")
                .details(details)
                .build();
        return new ResponseEntity<DataError>(dataError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<DataError> handleConstraintViolationException(ConstraintViolationException  ex) {
        Map<String,String> details = new HashMap<>();
        DataError dataError = DataError.builder().code(400).message(ex.getMessage()).details(details).build();
        return new ResponseEntity<>(dataError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DataError> handleNoSuchElementException(NoSuchElementException  ex) {
        Map<String,String> details = new HashMap<>();
        DataError dataError = DataError.builder().code(400).message(ex.getMessage()).details(details).build();
        return new ResponseEntity<>(dataError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<DataError> handleDateTimeParseException(DateTimeParseException  ex) {
        Map<String,String> details = new HashMap<>();
        DataError dataError = DataError.builder().code(400).message(ex.getMessage()).details(details).build();
        return new ResponseEntity<>(dataError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<DataError> handleNoResourceFoundException(NoResourceFoundException  ex) {
        Map<String,String> details = new HashMap<>();
        DataError dataError = DataError.builder().code(400).message(ex.getMessage()).details(details).build();
        return new ResponseEntity<>(dataError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<DataError> handleBadRequestException(BadRequestException  ex) {
        DataError dataError = DataError.builder().code(400).message(ex.getMessage()).details(ex.getDetails()).build();
        return new ResponseEntity<>(dataError, HttpStatus.BAD_REQUEST);
    }

}
