package com.kanjinumbers.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberToKanjiConverterTest {

    private NumberToKanjiConverter converter;

    @Before
    public void setUp() {
        converter = new NumberToKanjiConverter();
    }

    @Test
    public void test() {
        // TODO ここにテストケースを書いてください
    }

    @Test
    public void sample() {
        Assert.assertEquals("零", converter.toKanji(0));
    }

}
