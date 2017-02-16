package com.synisys.securityUtil;

/**
 * Created by Garik Kalashyan on 2/16/2017.
 */
public class LetterNotFoundException extends RuntimeException {
    public LetterNotFoundException() {
    }

    public LetterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LetterNotFoundException(String message) {
        super(message);
    }
}
