package com.example.errorhandling.exception.message;

import org.springframework.context.support.MessageSourceAccessor;

public class UserMessageResolver {
    private final MessageSourceAccessor messageSourceAccessor;

    public UserMessageResolver(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    public String getMessage(String messageKey) {
        return getMessage(messageKey, "");
    }

    public String getMessage(String messageKey, String defaultMsg) {
        return messageSourceAccessor.getMessage(messageKey, defaultMsg);
    }

    public String getMessage(String messageKey, Object[] args) {
        return messageSourceAccessor.getMessage(messageKey, args);
    }
}
