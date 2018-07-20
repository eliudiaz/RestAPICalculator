package com.upwork.computation.service;

import com.upwork.computation.controller.dto.Result;
import com.upwork.computation.exceptions.DivisionByZeroException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ComputationsServiceImplTest {

    private ComputationsService subject = new ComputationsServiceImpl();

    @Test
    public void testAdd() {
        List<Number> params = Arrays.asList(1, 2, 3);
        List<Number> negativeParams = Arrays.asList(1, 2, -3);

        Result result = subject.add(params);
        Assert.assertEquals(6.0d, result.getResult());

        result = subject.add(params);
        Assert.assertTrue(result.isCached());

        result = subject.add(negativeParams);
        Assert.assertEquals(0d, result.getResult());

        result = subject.add(negativeParams);
        Assert.assertTrue(result.isCached());

    }

    @Test
    public void testSubtract() {
        List<Number> params = Arrays.asList(3, 2, 1);
        List<Number> negativeParams = Arrays.asList(-1, -2, -3);

        Result result = subject.subtract(params);
        Assert.assertEquals(0d, result.getResult());

        result = subject.subtract(params);
        Assert.assertTrue(result.isCached());

        result = subject.subtract(negativeParams);
        Assert.assertEquals(4d, result.getResult());

        result = subject.subtract(negativeParams);
        Assert.assertTrue(result.isCached());

    }

    @Test
    public void testMultiply() {
        List<Number> params = Arrays.asList(3, 2, 1);
        List<Number> negativeParams = Arrays.asList(-1, -2, -3);

        Result result = subject.multiply(params);
        Assert.assertEquals(6d, result.getResult());

        result = subject.multiply(params);
        Assert.assertTrue(result.isCached());

        result = subject.multiply(negativeParams);
        Assert.assertEquals(-6d, result.getResult());

        result = subject.multiply(negativeParams);
        Assert.assertTrue(result.isCached());

    }

    @Test
    public void testDivide() {
        List<Number> params = Arrays.asList(3, 2);
        List<Number> negativeParams = Arrays.asList(-1, -2);

        Result result = subject.divide(params);
        Assert.assertEquals(1.5d, result.getResult());

        result = subject.divide(params);
        Assert.assertTrue(result.isCached());

        result = subject.divide(negativeParams);
        Assert.assertEquals(0.5, result.getResult());

        result = subject.divide(negativeParams);
        Assert.assertTrue(result.isCached());

    }

    @Test(expected = DivisionByZeroException.class)
    public void testDivideByZero() {
        List<Number> params = Arrays.asList(3, 0);
        subject.divide(params);
        Assert.fail();
    }

}