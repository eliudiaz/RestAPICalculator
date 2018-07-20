package com.upwork.computation.controller.impl;

import com.upwork.computation.controller.ComputationsEndpoint;
import com.upwork.computation.controller.dto.Result;
import com.upwork.computation.exceptions.InvalidParameterException;
import com.upwork.computation.service.ComputationsService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.PathSegment;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Component
public class ComputationsEndpointImpl implements ComputationsEndpoint {

    private final ComputationsService computationsService;

    public ComputationsEndpointImpl(ComputationsService computationsService) {
        this.computationsService = computationsService;
    }

    private List<Number> validate(List<PathSegment> params) {
        final Stream<PathSegment> valid = params.parallelStream().filter(param
                -> NumberUtils.isParsable(param.getPath()));
        if (valid.count() != params.size()) {
            throw new InvalidParameterException("One or more parameters are invalid!");
        }
        return params.stream().map(p -> Double.valueOf(p.getPath())).collect(toList());
    }

    @Override
    public Result add(List<PathSegment> params) {
        return computationsService.add(validate(params));
    }

    @Override
    public Result subtract(List<PathSegment> params) {
        return computationsService.subtract(validate(params));
    }

    @Override
    public Result multiply(List<PathSegment> params) {
        return computationsService.multiply(validate(params));
    }

    @Override
    public Result divide(List<PathSegment> params) {
        return computationsService.divide(validate(params));
    }
}
