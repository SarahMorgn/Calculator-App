package com.example.calculator;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

import androidx.test.filters.SmallTest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    Calculator mCalculator;
    @Before
    public void setUp(){
        mCalculator=new Calculator();
    }
    @Test
    public void addTwoPositiveNumbers(){
        double result=mCalculator.add(1d,1d);
        assertThat(result,is(equalTo(2d)));
    }
    @Test
    public void addTwoNumbersPositiveAndNegative(){
        double result=mCalculator.add(-1d,2d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void addTwoNegativeNumbers(){
        double result=mCalculator.add(-1d,-1d);
        assertThat(result,is(equalTo(-2d)));
    }
    @Test
    public void addTwoFloatNumbers(){
        double result=mCalculator.add(1.11d,1.11d);
        assertThat(result,is(equalTo(2.22d)));
    }
    @Test
    public void subTwoPositiveNumbers(){
        double result=mCalculator.sub(2d,1d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void subTwoNumbersPositiveAndNegative(){
        double result=mCalculator.sub(-1d,2d);
        assertThat(result,is(equalTo(-3d)));
    }
    @Test
    public void subTwoNegativeNumbers(){
        double result=mCalculator.sub(-2d,-1d);
        assertThat(result,is(equalTo(-1d)));
    }
    @Test
    public void subTwoFloatNumbers(){
        double result=mCalculator.sub(2.22d,1.11d);
        assertThat(result,is(equalTo(1.11d)));
    }
    @Test
    public void multiTwoPositiveNumbers(){
        double result=mCalculator.multi(1d,1d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void multiTwoNumbersPositiveAndNegative(){
        double result=mCalculator.multi(-1d,2d);
        assertThat(result,is(equalTo(-2d)));
    }
    @Test
    public void multiTwoNegativeNumbers(){
        double result=mCalculator.multi(-1d,-1d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void multiTwoFloatNumbers(){
        double result=mCalculator.multi(1.11d,1.11d);
        assertThat(result,is(Matchers.closeTo(1.23d,0.01)));
    }
    @Test
    public void divTwoPositiveNumbers(){
        double result=mCalculator.div(2d,1d);
        assertThat(result,is(equalTo(2d)));
    }
    @Test
    public void divTwoNumbersPositiveAndNegative(){
        double result=mCalculator.div(-1d,2d);
        assertThat(result,is(equalTo(-0.5d)));
    }
    @Test
    public void divTwoNegativeNumbers(){
        double result=mCalculator.div(-1d,-1d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void divTwoFloatNumbers(){
        double result=mCalculator.div(1.11d,1.11d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void modTwoPositiveNumbers(){
        double result=mCalculator.mod(4d,3d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void modTwoNumbersPositiveAndNegative(){
        double result=mCalculator.mod(-4d,3d);
        assertThat(result,is(equalTo(-1d)));
    }
    @Test
    public void modTwoNegativeNumbers(){
        double result=mCalculator.mod(-4d,-3d);
        assertThat(result,is(equalTo(-1d)));
    }
    @Test
    public void modTwoFloatNumbers(){
        double result=mCalculator.mod(1.11d,1.11d);
        assertThat(result,is(closeTo(0.01d,0.01)));
    }
}