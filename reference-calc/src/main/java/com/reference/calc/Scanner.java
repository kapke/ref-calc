package com.reference.calc;

import com.reference.calc.exception.TokenizeException;
import com.reference.calc.token.Token;
import com.reference.calc.token.TokenInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kapke on 21.11.15.
 */
public class Scanner {
    public static final List<Token> defaultTokens = Arrays.asList(
        new Token("empty", "\\s+"),
        new Token("opening_brace", "\\("),
        new Token("closing_brace", "\\)"),
        new Token("number", "\\d+(\\.\\d+)?"),
        new Token("symbol_plus", "\\+"),
        new Token("symbol_minus", "-"),
        new Token("symbol_asterisk", "\\*"),
        new Token("symbol_slash", "/"));

    private List<Token> tokens;

    public Scanner() {
        this(defaultTokens);
    }

    public Scanner(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<TokenInstance> sanitize (List<TokenInstance> tokens) {
        return tokens.stream()
                .filter(tokenInstance -> !tokenInstance.getType().equals("empty"))
                .collect(Collectors.toList());
    }

    public List<TokenInstance> tokenize (String originalExpression) throws TokenizeException {
        List<TokenInstance> output = new ArrayList<>();

        int pos = 1;
        String expression = originalExpression;

        while(!expression.isEmpty()) {
            String substring = expression.substring(0, pos);
            Token token = getMatchingToken(substring);

            if(token != null) {
                TokenInstance longestMatching = getLongestMatchingTokenInstance(token, expression);
                output.add(longestMatching);
                pos = longestMatching.getValue().length();
                expression = expression.substring(pos);
                pos = 1;
            } else if (pos < expression.length()) {
                pos += 1;
            } else {
                throw new TokenizeException(originalExpression);
            }
        }

        return output;
    }

    private TokenInstance getLongestMatchingTokenInstance(Token token, String expression) {
        String lastMatching = expression.substring(0, 1);
        for(int i=1;i<expression.length()+1; i++) {
            String substring = expression.substring(0, i);
            if(token.matches(substring)) {
                lastMatching = substring;
            }
        }

        return token.getInstance(lastMatching);
    }

    private Token getMatchingToken (String expression) {
        for(Token token : tokens) {
            if(token.matches(expression)) {
                return token;
            }
        }

        return null;
    }
}
