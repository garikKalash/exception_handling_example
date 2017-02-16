package com.synisys.securityUtil;

/**
 * Created by Garik Kalashyan on 2/16/2017.
 */
public class CommandNotFoundException extends RuntimeException {
    public CommandNotFoundException() {
    }

    public CommandNotFoundException(String message) {
        super(message);
    }

    public CommandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
