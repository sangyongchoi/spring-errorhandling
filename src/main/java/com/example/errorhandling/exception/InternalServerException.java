package com.example.errorhandling.exception;

import com.example.errorhandling.exception.code.ErrorCode;
import com.example.errorhandling.exception.code.ErrorType;

public class InternalServerException extends CoreBaseException {
    private static final ErrorType DEFAULT_ERROR_TYPE = ErrorType.INTERNAL_SERVER_ERROR;

    public InternalServerException(ErrorCode errorCode) {
        super(DEFAULT_ERROR_TYPE, errorCode);
    }

    public InternalServerException(ErrorCode errorCode, Throwable t) {
        super(DEFAULT_ERROR_TYPE, errorCode, t);
    }

    public InternalServerException(ErrorCode errorCode, String userMsg) {
        super(DEFAULT_ERROR_TYPE, errorCode, userMsg);
    }

    public InternalServerException(ErrorCode errorCode, String userMsg, Throwable t) {
        super(DEFAULT_ERROR_TYPE, errorCode, userMsg, t);
    }
}
