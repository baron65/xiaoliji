package com.tts.xiaoliji.common.bean;

public class DomainValue {
    private String value;
    private String label;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "DomainValue [value=" + value + ", label=" + label + "]";
    }
}
