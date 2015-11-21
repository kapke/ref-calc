package com.reference.calc;

import com.reference.calc.exception.ParseErrorException;
import com.reference.calc.token.Token;
import com.reference.calc.token.TokenInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kapke on 21.11.15.
 */
public class Tokenizer {
    public static final List<Token> defaultTokens = Arrays.asList(
        new Token("empty", "\\s+"),
        new Token("opening_brace", "\\("),
        new Token("closing_brace", "\\)"),
        new Token("number", "\\d+(\\.\\d+)?"),
        new Token("symbol_addition", "\\+"),
        new Token("symbol_subtraction", "-"),
        new Token("symbol_multiplication", "\\*"),
        new Token("symbol_division", "/"));

    private List<Token> tokens;

    public Tokenizer () {
        this(defaultTokens);
    }

    public Tokenizer (List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<TokenInstance> tokenize (String originalExpression) throws ParseErrorException {
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
                throw new ParseErrorException(originalExpression);
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
