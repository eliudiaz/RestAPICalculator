package com.upwork.computation.controller.dto;

import java.util.List;

public class Result {
    private List<Number> parameters;
    private Number result;
    private boolean cached;

    public Result(List<Number> parameters, Number result) {
        this.parameters = parameters;
        this.result = result;
        this.cached = false;
    }

    public Result(List<Number> parameters, Number result, boolean cached) {
        this.parameters = parameters;
        this.result = result;
        this.cached = cached;
    }

    public List<Number> getParameters() {
        return parameters;
    }

    public void setParameters(List<Number> parameters) {
        this.parameters = parameters;
    }

    public Number getResult() {
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public boolean isCached() {
        return cached;
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }
}
