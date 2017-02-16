package com.synisys.securityUtil;

/**
 * Created by Garik Kalashyan on 2/16/2017.
 */
public class NumbersNotFoundException extends RuntimeException {

    public NumbersNotFoundException() {
    }

    public NumbersNotFoundException(String message) {
        super(message);
    }

    public NumbersNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
