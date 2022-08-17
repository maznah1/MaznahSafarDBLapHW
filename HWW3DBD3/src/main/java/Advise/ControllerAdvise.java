package Advise;


import AipException.AipException;
import dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(value = AipException.class)
    public ResponseEntity apiException (AipException aipException){
        return ResponseEntity.status(400).body(new ApiResponse(aipException.getMessage(),400));
    }


}
