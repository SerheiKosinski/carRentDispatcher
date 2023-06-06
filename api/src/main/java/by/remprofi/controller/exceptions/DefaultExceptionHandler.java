package by.remprofi.controller.exceptions;

import by.remprofi.util.RandomValuesGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

import static by.remprofi.controller.response.ApplicationErrorCodes.BAD_REQUEST_USER_CREATE;
import static by.remprofi.controller.response.ApplicationErrorCodes.FATAL_ERROR;
import static by.remprofi.controller.response.ApplicationErrorCodes.USER_NOT_FOUND;

@ControllerAdvice
@RequiredArgsConstructor
public class DefaultExceptionHandler {
    private static final Logger log = Logger.getLogger(DefaultExceptionHandler.class);

    private final RandomValuesGenerator generator;

    @ExceptionHandler(IllegalRequestException.class)
    public ResponseEntity<ErrorMessage> handleIllegalRequestException(IllegalRequestException e) {
        String exceptionUniqueId = generator.uuidGenerator();

        BindingResult bindingResult = e.getBindingResult();
        String collect = bindingResult
                .getAllErrors()
                .stream()
                .map(ObjectError::toString)
                .collect(Collectors.joining(","));

        log.error(exceptionUniqueId + e.getMessage(), e);

        return new ResponseEntity<>(
                new ErrorMessage(
                        exceptionUniqueId,
                        BAD_REQUEST_USER_CREATE.getCodeId(),
                        collect
                ),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleOthersException(Exception e) {


        String exceptionUniqueId = generator.uuidGenerator();

        log.error(exceptionUniqueId + e.getMessage(), e);

        return new ResponseEntity<>(
                new ErrorMessage(
                        exceptionUniqueId,
                        FATAL_ERROR.getCodeId(),
                        e.getMessage()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException e) {

        String exceptionUniqueId = generator.uuidGenerator();

        log.error(exceptionUniqueId + e.getMessage(), e);

        return new ResponseEntity<>(
                new ErrorMessage(
                        exceptionUniqueId,
                        USER_NOT_FOUND.getCodeId(),
                        e.getMessage()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
