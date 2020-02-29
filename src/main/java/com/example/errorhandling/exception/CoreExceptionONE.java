package com.example.errorhandling.exception;

import com.example.errorhandling.exception.code.ErrorCode;
import com.example.errorhandling.exception.code.ErrorType;

public class CoreExceptionONE extends  CoreBaseException{
    private static final ErrorType error_type = ErrorType.ERROR_ONE;

    public CoreExceptionONE(ErrorCode errorCode) {
        super(error_type, errorCode);
    }

    public CoreExceptionONE(ErrorCode errorCode, Throwable t) {
        super(error_type, errorCode, t);
    }

    public CoreExceptionONE(ErrorCode errorCode, String userMsg) {
        super(error_type, errorCode, userMsg);
    }

    public CoreExceptionONE(ErrorCode errorCode, String userMsg, Throwable t) {
        super(error_type, errorCode, userMsg, t);
    }
}
