package com.upwork.computation.service;

import com.upwork.computation.controller.dto.Result;

import java.util.List;

public interface ComputationsService {

    Result add(List<Number> parameters);
    Result subtract(List<Number> parameters);
    Result multiply(List<Number> parameters);
    Result divide(List<Number> parameters);
}
