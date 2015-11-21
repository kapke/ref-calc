package com.reference.calc;

import com.reference.calc.exception.ParseException;
import com.reference.calc.token.TokenInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private List<Production> terminalProductions;
    private List<Production> nonTerminalProductions;

    public Parser () {
        this.terminalProductions = Arrays.asList(
            new Production("negative_number", new String[]{"symbol_minus", "number"}),
            new Production("negative_number", new String[]{"opening_brace", "negative_number", "closing_brace"}),
            new Production("operation_binary_multiplication", new String[]{"number", "symbol_asterisk", "number"}),
            new Production("operation_binary_division", new String[]{"number", "symbol_slash", "number"}),
            new Production("operation_binary_addition", new String[]{"number", "symbol_plus", "number"}),
            new Production("operation_binary_subtraction", new String[]{"number", "symbol_minus", "number"}),
            new Production("operation_binary_subtraction", new String[]{"number", "negative_number"})
        );
        this.nonTerminalProductions = Arrays.asList(
            new Production("number", "negative_number"),
            new Production("expression", "number"),
            new Production("operation_binary", "operation_binary_multiplication"),
            new Production("operation_binary", "operation_binary_division"),
            new Production("operation_binary", "operation_binary_addition"),
            new Production("operation_binary", "operation_binary_subtraction"),
            new Production("operation", "operation_binary"),
            new Production("expression", "operation"),
            new Production("expression", new String[]{ "opening_brace", "expression", "closing_brace"}),
            new Production("operation_binary_multiplication", new String[]{"expression", "symbol_asterisk", "expression"}),
            new Production("operation_binary_division", new String[]{"expression", "symbol_slash", "expression"}),
            new Production("operation_binary_addition", new String[]{"expression", "symbol_plus", "expression"}),
            new Production("operation_binary_subtraction", new String[]{"expression", "symbol_minus", "expression"})
        );
    }

    public TokenInstance parse (List<TokenInstance> tokens) throws ParseException {
        List<TokenInstance> treeBase = new ArrayList<>(tokens);

        int previousSize = treeBase.size();
        int tries = 0;

        do {
            if(previousSize == treeBase.size()) {
                tries += 1;
            } else {
                previousSize = treeBase.size();
                tries = 0;
            }
            treeBase = reduceTokensUsingProductions(terminalProductions, treeBase);
            treeBase = reduceTokensUsingProductions(nonTerminalProductions, treeBase);
        } while (previousSize != treeBase.size() || tries < 5);

        if(treeBase.size() != 1) {
            throw new ParseException(tokens);
        }

        return treeBase.get(0);
    }

    private int findFirstIndexMatchingProduction (Production production, List<TokenInstance> tokens) {
        List<String> pattern = production.getPattern();
        for(int i=0; i<=tokens.size()-production.getPattern().size(); i++) {
            int currentPosition = i;
            for(String patternElement : pattern) {
                if(tokens.get(currentPosition).getType().equals(patternElement)) {
                    currentPosition += 1;
                }
            }

            if(currentPosition == i+pattern.size()) {
                return i;
            }
        }

        return -1;
    }

    private List<TokenInstance> replaceTokensUsingProduction (int index, Production production, List<TokenInstance> tokens) {
        List<TokenInstance> output = new ArrayList<>(tokens);
        TokenInstance complexTokenInstance = new TokenInstance(production.getType(), tokens.subList(index, index+production.getPattern().size()));
        output.add(index, complexTokenInstance);
        for(int i=0; i<production.getPattern().size(); i++) {
            output.remove(index+1);
        }

        return output;
    }

    private List<TokenInstance> reduceTokensUsingProductions (List<Production> productions, List<TokenInstance> tokens) {
        List<TokenInstance> output = new ArrayList<>(tokens);
        for(Production production : productions) {
            int foundIndex;
            do {
                foundIndex = findFirstIndexMatchingProduction(production, output);
                if(foundIndex >= 0) {
                    output = replaceTokensUsingProduction(foundIndex, production, output);
                }
            } while (foundIndex >= 0);
        }

        return output;
    }
}
