package com.synisys.securityUtil;

import java.io.IOException;

/**
 * Created by Garik Kalashyan on 2/16/2017.
 */
public class ResourcesNotFoundException extends IOException {
    public ResourcesNotFoundException(String message) {
        super(message);
    }

    public ResourcesNotFoundException() {
    }

    public ResourcesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
