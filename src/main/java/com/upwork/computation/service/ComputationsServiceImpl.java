package com.upwork.computation.service;

import com.upwork.computation.controller.dto.Result;
import com.upwork.computation.exceptions.DivisionByZeroException;
import com.upwork.computation.exceptions.UnsupportedArithmeticalOperation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public class ComputationsServiceImpl implements ComputationsService {
    private static Map<String, Number> cache = new ConcurrentHashMap<>();

    private enum ArithmeticalOperation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }


    @Override
    public Result add(List<Number> parameters) {
        return calculate(ArithmeticalOperation.ADD, parameters);
    }


    @Override
    public Result subtract(List<Number> parameters) {
        return calculate(ArithmeticalOperation.SUBTRACT, parameters);
    }

    @Override
    public Result multiply(List<Number> parameters) {
        return calculate(ArithmeticalOperation.MULTIPLY, parameters);
    }

    @Override
    public Result divide(List<Number> parameters) {
        return calculate(ArithmeticalOperation.DIVIDE, parameters);
    }

    private Result calculate(ArithmeticalOperation operation, List<Number> parameters) {
        final String expr = buildExpr(operation, parameters);

        if (isCached(expr))
            return new Result(parameters, fromCache(expr), true);

        final Number result = operate(operation, parameters);
        cache.put(expr, result);
        return new Result(parameters, result);
    }

    private boolean isCached(String expr) {
        return cache.containsKey(expr);
    }

    private Number fromCache(String expr) {
        return cache.get(expr);
    }

    private String buildExpr(ArithmeticalOperation operation, List<Number> values) {
        return operation.toString().toLowerCase().concat(values.stream().map(v -> v.toString()).collect(Collectors.joining()));
    }

    private Number operate(ArithmeticalOperation operation, List<Number> values) {
        switch (operation) {
            case ADD:
                return values.stream().flatMapToDouble(v -> DoubleStream.of(v.doubleValue()))
                        .sum();
            case MULTIPLY:
                return values.stream().flatMapToDouble(v -> DoubleStream.of(v.doubleValue()))
                        .reduce(1, (a, b) -> a * b);
            case SUBTRACT:
                return subtraction(values);

            case DIVIDE:
                return divide(values.get(0), values.get(1));
            default:
                throw new UnsupportedArithmeticalOperation();
        }
    }

    private Number subtraction(List<Number> parameters) {
        Iterator<Number> iterator = parameters.iterator();
        Double acc = iterator.next().doubleValue();
        while (iterator.hasNext()) {
            acc = acc - iterator.next().doubleValue();
        }
        return acc;
    }

    private Number divide(Number a, Number b) {
        if (b.longValue() == 0) {
            throw new DivisionByZeroException();
        }
        return BigDecimal.valueOf(a.doubleValue()).divide(BigDecimal.valueOf(b.doubleValue())).doubleValue();
    }
}
