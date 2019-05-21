package com.kanjinumbers.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KanjiToNumberConverterTest {

    private KanjiToNumberConverter converter;

    @Before
    public void setUp() {
        converter = new KanjiToNumberConverter();
    }

    @Test
    public void testSingleDigit() {
        Assert.assertEquals(0, converter.toNumber("零"));
        Assert.assertEquals(1, converter.toNumber("壱"));
        Assert.assertEquals(2, converter.toNumber("弐"));
        Assert.assertEquals(3, converter.toNumber("参"));
        Assert.assertEquals(4, converter.toNumber("四"));
        Assert.assertEquals(5, converter.toNumber("五"));
        Assert.assertEquals(6, converter.toNumber("六"));
        Assert.assertEquals(7, converter.toNumber("七"));
        Assert.assertEquals(8, converter.toNumber("八"));
        Assert.assertEquals(9, converter.toNumber("九"));
    }

    @Test
    public void testDoubleDigit() {
        assertEquals(10, converter.toNumber("壱拾"));
        assertEquals(11, converter.toNumber("壱拾壱"));
        assertEquals(12, converter.toNumber("壱拾弐"));
        assertEquals(13, converter.toNumber("壱拾参"));
        assertEquals(14, converter.toNumber("壱拾四"));
        assertEquals(20, converter.toNumber("弐拾"));
        assertEquals(21, converter.toNumber("弐拾壱"));
        assertEquals(22, converter.toNumber("弐拾弐"));
        assertEquals(23, converter.toNumber("弐拾参"));
        assertEquals(30, converter.toNumber("参拾"));
        assertEquals(31, converter.toNumber("参拾壱"));
        assertEquals(32, converter.toNumber("参拾弐"));
        assertEquals(33, converter.toNumber("参拾参"));
    }

    @Test
    public void testHundred() {
        assertEquals(100, converter.toNumber("壱百"));
        assertEquals(101, converter.toNumber("壱百壱"));
        assertEquals(102, converter.toNumber("壱百弐"));
        assertEquals(103, converter.toNumber("壱百参"));
        assertEquals(110, converter.toNumber("壱百壱拾"));
        assertEquals(111, converter.toNumber("壱百壱拾壱"));
        assertEquals(112, converter.toNumber("壱百壱拾弐"));
        assertEquals(113, converter.toNumber("壱百壱拾参"));
        assertEquals(200, converter.toNumber("弐百"));
        assertEquals(210, converter.toNumber("弐百壱拾"));
        assertEquals(211, converter.toNumber("弐百壱拾壱"));
    }

    @Test
    public void testThousand() {
        assertEquals(1000, converter.toNumber("壱千"));
        assertEquals(1001, converter.toNumber("壱千壱"));
        assertEquals(1002, converter.toNumber("壱千弐"));
        assertEquals(1003, converter.toNumber("壱千参"));
        assertEquals(1010, converter.toNumber("壱千壱拾"));
        assertEquals(1011, converter.toNumber("壱千壱拾壱"));
        assertEquals(1100, converter.toNumber("壱千壱百"));
        assertEquals(1101, converter.toNumber("壱千壱百壱"));
        assertEquals(1110, converter.toNumber("壱千壱百壱拾"));
        assertEquals(1111, converter.toNumber("壱千壱百壱拾壱"));
    }

    @Test
    public void testTenThousand() {
        assertEquals(10000, converter.toNumber("壱万"));
        assertEquals(10001, converter.toNumber("壱万壱"));
        assertEquals(10002, converter.toNumber("壱万弐"));
        assertEquals(10003, converter.toNumber("壱万参"));
        assertEquals(10010, converter.toNumber("壱万壱拾"));
        assertEquals(10011, converter.toNumber("壱万壱拾壱"));
        assertEquals(10100, converter.toNumber("壱万壱百"));
        assertEquals(10101, converter.toNumber("壱万壱百壱"));
        assertEquals(10110, converter.toNumber("壱万壱百壱拾"));
        assertEquals(10111, converter.toNumber("壱万壱百壱拾壱"));
        assertEquals(11000, converter.toNumber("壱万壱千"));
        assertEquals(11001, converter.toNumber("壱万壱千壱"));
        assertEquals(11010, converter.toNumber("壱万壱千壱拾"));
        assertEquals(11011, converter.toNumber("壱万壱千壱拾壱"));
    }

    @Test
    public void testMillionaire() {
        assertEquals(1_000_000, converter.toNumber("壱百万"));
        assertEquals(10_000_000, converter.toNumber("壱千万"));
        assertEquals(100_000_000, converter.toNumber("壱億"));
        assertEquals(1_000_000_000, converter.toNumber("壱拾億"));
        assertEquals(10_000_000_000L, converter.toNumber("壱百億"));
        assertEquals(100_000_000_000L, converter.toNumber("壱千億"));
        assertEquals(1_000_000_000_000L, converter.toNumber("壱兆"));
        assertEquals(10_000_000_000_000L, converter.toNumber("壱拾兆"));
        assertEquals(100_000_000_000_000L, converter.toNumber("壱百兆"));
        assertEquals(1_000_000_000_000_000L, converter.toNumber("壱千兆"));
        assertEquals(9_999_999_999_999_999L, converter.toNumber("九千九百九拾九兆九千九百九拾九億九千九百九拾九万九千九百九拾九"));
    }

    @Test
    public void testIllegalArgument() {
        assertEquals(-1, converter.toNumber("一万"));
        assertEquals(-1, converter.toNumber("拾"));
        assertEquals(-1, converter.toNumber("百"));
        assertEquals(-1, converter.toNumber("千"));
        assertEquals(-1, converter.toNumber("万"));
        assertEquals(-1, converter.toNumber("億"));
        assertEquals(-1, converter.toNumber("兆"));
        assertEquals(-1, converter.toNumber("京"));
    }

}
