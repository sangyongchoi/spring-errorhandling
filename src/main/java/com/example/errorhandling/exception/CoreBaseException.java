package com.example.errorhandling.exception;

import com.example.errorhandling.exception.code.ErrorCode;
import com.example.errorhandling.exception.code.ErrorType;
import lombok.Getter;
import lombok.ToString;

import static java.lang.String.format;


@ToString
@Getter
public abstract class CoreBaseException extends RuntimeException{
    private static String EXCEPTION_MSG_FORMAT = "ErrorType : %s, ErrorCode:%s,userMsg : '%s'";
    private ErrorCode errorCode;
    private ErrorType errorType;
    private String userMsg;

    public CoreBaseException(ErrorType errorType, ErrorCode errorCode) {
        super(format(EXCEPTION_MSG_FORMAT, errorType, errorCode, "N/A"));
        this.errorType = errorType;
        this.errorCode = errorCode;
    }

    public CoreBaseException(ErrorType errorType, ErrorCode errorCode, Throwable t) {
        super(format(EXCEPTION_MSG_FORMAT, errorType, errorCode, "N/A"), t);
        this.errorType = errorType;
        this.errorCode = errorCode;
    }

    public CoreBaseException(ErrorType errorType, ErrorCode errorCode, String userMsg) {
        super(format(EXCEPTION_MSG_FORMAT, errorType, errorCode, userMsg));
        this.errorType = errorType;
        this.errorCode = errorCode;
        this.userMsg = userMsg;
    }

    public CoreBaseException(ErrorType errorType, ErrorCode errorCode, String userMsg, Throwable t) {
        super(format(EXCEPTION_MSG_FORMAT, errorType, errorCode, userMsg), t);
        this.errorType = errorType;
        this.errorCode = errorCode;
        this.userMsg = userMsg;
    }
}
