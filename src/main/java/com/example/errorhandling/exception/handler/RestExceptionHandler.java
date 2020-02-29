package com.example.errorhandling.exception.handler;

import com.example.errorhandling.exception.CoreBaseException;
import com.example.errorhandling.exception.code.ErrorCode;
import com.example.errorhandling.exception.message.UserMessageResolver;
import com.example.errorhandling.exception.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@RestControllerAdvice
public class RestExceptionHandler {
    private final UserMessageResolver userMessageResolver;


    public RestExceptionHandler(UserMessageResolver userMessageResolver) {
        this.userMessageResolver = userMessageResolver;
    }

    @ExceptionHandler(CoreBaseException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleCoreException(CoreBaseException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(e.getErrorCode().getCode())
                .message(e.getMessage())
                .user_message(getUserMessage(e.getErrorCode(),e.getUserMsg()))
                .build();

        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleException(Exception e){

        return ErrorResponse.builder()
                .code(ErrorCode.ERR_UNKNOWN.getCode())
                .message(ErrorCode.ERR_UNKNOWN.getMessage())
                .user_message(getUserMessage(ErrorCode.ERR_UNKNOWN,EMPTY))
                .build();
    }
    private String getUserMessage(ErrorCode errorCode, String defaultMsg) {
        return userMessageResolver.getMessage(errorCode.getCode(), defaultMsg);
    }


}

