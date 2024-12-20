package md.utm.rentalmanagement.exception;

import jakarta.servlet.http.HttpServletRequest;
import md.utm.rentalmanagement.exception.type.AlreadyExistException;
import md.utm.rentalmanagement.exception.type.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ExceptionModel> notFoundEntity(ChangeSetPersister.NotFoundException e, HttpServletRequest request) {

        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setTimestamp(Instant.now().toString());
        exceptionModel.setError("Entity not found");
        exceptionModel.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionModel.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionModel);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ExceptionModel> alreadyExistsEntity(AlreadyExistException e, HttpServletRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setTimestamp(Instant.now().toString());
        exceptionModel.setError("Entity already exists");
        exceptionModel.setStatus(HttpStatus.CONFLICT.value());
        exceptionModel.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionModel);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionModel> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setTimestamp(Instant.now().toString());
        exceptionModel.setError(e.getBindingResult().getAllErrors().getFirst().getDefaultMessage());
        exceptionModel.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionModel.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionModel);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionModel> handleNotFoundException(NotFoundException e, HttpServletRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setTimestamp(Instant.now().toString());
        exceptionModel.setError("Resource not found");
        exceptionModel.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionModel.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionModel);
    }
}
