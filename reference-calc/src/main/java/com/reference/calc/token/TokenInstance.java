package com.reference.calc.token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kapke on 21.11.15.
 */
public class TokenInstance {
    private final String type;
    private final List<TokenInstance> params;
    private final String value;

    TokenInstance (String type, String value) {
        this.type = type;
        this.value = value;
        this.params = new ArrayList<>();
    }

    public TokenInstance (String type, List<TokenInstance> params) {
        this.type = type;
        this.value = params.stream()
                .map(TokenInstance::getValue)
                .reduce("", (acc, val) -> acc + val);
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public List<TokenInstance> getParams() {
        return params;
    }

    public boolean matchesPattern (String[] pattern) {
        if(pattern.length == params.size()) {
            for(int i=0; i<params.size(); i++) {
                if(!params.get(i).getType().equals(pattern[i])) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString () {
        return type+", "+value;
    }
}
