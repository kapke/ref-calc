package com.reference.calc.token;

/**
 * Created by kapke on 21.11.15.
 */
public class Token {
    private final String type;
    private final String pattern;

    public Token (String type, String pattern) {
        this.type = type;
        this.pattern = pattern;
    }

    public String getType() {
        return type;
    }

    public String getPattern() {
        return pattern;
    }

    public boolean matches (String expression) {
        return expression.matches(pattern);
    }

    public TokenInstance getInstance (String expression) {
        return new TokenInstance(type, expression);
    }
}
