package com.kanjinumbers.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class NumberToKanjiConverterTest {

    private NumberToKanjiConverter converter;

    @Before
    public void setUp() {
        converter = new NumberToKanjiConverter();
    }

    @Test
    public void testSingleDigit() {
        assertEquals("零", converter.toKanji(0));
        assertEquals("壱", converter.toKanji(1));
        assertEquals("弐", converter.toKanji(2));
        assertEquals("参", converter.toKanji(3));
        assertEquals("四", converter.toKanji(4));
        assertEquals("五", converter.toKanji(5));
        assertEquals("六", converter.toKanji(6));
        assertEquals("七", converter.toKanji(7));
        assertEquals("八", converter.toKanji(8));
        assertEquals("九", converter.toKanji(9));
    }

    @Test
    public void testDoubleDigit() {
        assertEquals("壱拾", converter.toKanji(10));
        assertEquals("壱拾壱", converter.toKanji(11));
        assertEquals("壱拾弐", converter.toKanji(12));
        assertEquals("壱拾参", converter.toKanji(13));
        assertEquals("壱拾四", converter.toKanji(14));
        assertEquals("弐拾", converter.toKanji(20));
        assertEquals("弐拾壱", converter.toKanji(21));
        assertEquals("弐拾弐", converter.toKanji(22));
        assertEquals("弐拾参", converter.toKanji(23));
        assertEquals("参拾", converter.toKanji(30));
        assertEquals("参拾壱", converter.toKanji(31));
        assertEquals("参拾弐", converter.toKanji(32));
        assertEquals("参拾参", converter.toKanji(33));
    }

    @Test
    public void testHundred() {
        assertEquals("壱百", converter.toKanji(100));
        assertEquals("壱百壱", converter.toKanji(101));
        assertEquals("壱百弐", converter.toKanji(102));
        assertEquals("壱百参", converter.toKanji(103));
        assertEquals("壱百壱拾", converter.toKanji(110));
        assertEquals("壱百壱拾壱", converter.toKanji(111));
        assertEquals("壱百壱拾弐", converter.toKanji(112));
        assertEquals("壱百壱拾参", converter.toKanji(113));
        assertEquals("弐百", converter.toKanji(200));
        assertEquals("弐百壱拾", converter.toKanji(210));
        assertEquals("弐百壱拾壱", converter.toKanji(211));
    }

    @Test
    public void testThousand() {
        assertEquals("壱千", converter.toKanji(1000));
        assertEquals("壱千壱", converter.toKanji(1001));
        assertEquals("壱千弐", converter.toKanji(1002));
        assertEquals("壱千参", converter.toKanji(1003));
        assertEquals("壱千壱拾", converter.toKanji(1010));
        assertEquals("壱千壱拾壱", converter.toKanji(1011));
        assertEquals("壱千壱百", converter.toKanji(1100));
        assertEquals("壱千壱百壱", converter.toKanji(1101));
        assertEquals("壱千壱百壱拾", converter.toKanji(1110));
        assertEquals("壱千壱百壱拾壱", converter.toKanji(1111));
    }

    @Test
    public void testTenThousand() {
        assertEquals("壱万", converter.toKanji(10000));
        assertEquals("壱万壱", converter.toKanji(10001));
        assertEquals("壱万弐", converter.toKanji(10002));
        assertEquals("壱万参", converter.toKanji(10003));
        assertEquals("壱万壱拾", converter.toKanji(10010));
        assertEquals("壱万壱拾壱", converter.toKanji(10011));
        assertEquals("壱万壱百", converter.toKanji(10100));
        assertEquals("壱万壱百壱", converter.toKanji(10101));
        assertEquals("壱万壱百壱拾", converter.toKanji(10110));
        assertEquals("壱万壱百壱拾壱", converter.toKanji(10111));
        assertEquals("壱万壱千", converter.toKanji(11000));
        assertEquals("壱万壱千壱", converter.toKanji(11001));
        assertEquals("壱万壱千壱拾", converter.toKanji(11010));
        assertEquals("壱万壱千壱拾壱", converter.toKanji(11011));
    }

    @Test
    public void testMillionaire() {
        assertEquals("壱百万", converter.toKanji(1000000));
        assertEquals("壱千万", converter.toKanji(10000000));
        assertEquals("壱億", converter.toKanji(100000000));
        assertEquals("壱拾億", converter.toKanji(1000000000));
        assertEquals("壱百億", converter.toKanji(10000000000L));
        assertEquals("壱千億", converter.toKanji(100000000000L));
        assertEquals("壱兆", converter.toKanji(1000000000000L));
        assertEquals("壱拾兆", converter.toKanji(10000000000000L));
        assertEquals("壱百兆", converter.toKanji(100000000000000L));
        assertEquals("壱千兆", converter.toKanji(1000000000000000L));
        assertEquals("九千九百九拾九兆九千九百九拾九億九千九百九拾九万九千九百九拾九", converter.toKanji(9_999_999_999_999_999L));
    }

    @Test
    public void testIllegalArgument() {
        assertNull(converter.toKanji(10_000_000_000_000_000L));
        assertNull(converter.toKanji(Long.MAX_VALUE));
        assertNull(converter.toKanji(-1));
        assertNull(converter.toKanji(Long.MIN_VALUE));
    }
}
