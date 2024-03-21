package com.lnw.assessment.pom.utils;

public enum Constant {
	
	
	CHROME("chrome"),
    FIREFOX("firefox"),
    SAFARI("safari");

	private String values;

    Constant(String values) {
        this.values = values;
    }

    public String getValue() {
        return values;
    }

    public String toString() {
        return this.values;
    }
}
