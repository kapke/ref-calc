package com.reference.calc;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kapke on 21.11.15.
 */
class Production {
    private final String type;
    private final List<String> pattern;

    public Production (String type, String[] pattern) {
        this.type = type;
        this.pattern = Arrays.asList(pattern);
    }

    public Production (String type, String pattern) {
        this(type, new String[] {pattern});
    }

    public String getType() {
        return type;
    }

    public List<String> getPattern() {
        return pattern;
    }

    public String toString () {
        return type + "->" + StringUtils.join(pattern, ",");
    }
}
