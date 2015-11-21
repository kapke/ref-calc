package com.reference.calc.exception;

import com.reference.calc.token.TokenInstance;

import java.util.List;

/**
 * Created by kapke on 21.11.15.
 */
public class ParseException extends CalcException {
    private final List<TokenInstance> tokens;

    public ParseException(List<TokenInstance> tokens) {
        super("Parsing given token list failed: "+tokens.stream()
            .map(token -> token.getValue())
            .reduce("", (acc, val) -> acc + val));
        this.tokens = tokens;
    }

    public List<TokenInstance> getTokens() {
        return tokens;
    }
}
