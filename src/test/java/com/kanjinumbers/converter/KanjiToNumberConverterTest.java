package com.kanjinumbers.converter;

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
    public void test() {
        // TODO ここにテストケースを書いてください
    }

    @Test
    public void sample() {
        Assert.assertEquals(0, converter.toNumber("零"));
    }

}
