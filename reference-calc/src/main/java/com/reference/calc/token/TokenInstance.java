package com.reference.calc.token;

/**
 * Created by kapke on 21.11.15.
 */
public class TokenInstance {
    private final String type;
    private final String value;

    TokenInstance (String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
