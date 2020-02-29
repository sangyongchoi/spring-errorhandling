package com.example.errorhandling.exception;

import com.example.errorhandling.exception.code.ErrorCode;
import com.example.errorhandling.exception.code.ErrorType;

public class CoreExceptionTWO extends CoreBaseException {
    private static final ErrorType error_type = ErrorType.ERROR_TWO;

    public CoreExceptionTWO(ErrorCode errorCode) {
        super(error_type, errorCode);
    }

    public CoreExceptionTWO(ErrorCode errorCode, Throwable t) {
        super(error_type, errorCode, t);
    }

    public CoreExceptionTWO(ErrorCode errorCode, String userMsg) {
        super(error_type, errorCode, userMsg);
    }

    public CoreExceptionTWO(ErrorCode errorCode, String userMsg, Throwable t) {
        super(error_type, errorCode, userMsg, t);
    }
}
