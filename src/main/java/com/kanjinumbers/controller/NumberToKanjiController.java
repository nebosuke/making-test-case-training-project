package com.kanjinumbers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kanjinumbers.BadRequestException;
import com.kanjinumbers.converter.NumberToKanjiConverter;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/number2kanji")
public class NumberToKanjiController {

    private static final Logger LOG = LoggerFactory.getLogger(NumberToKanjiController.class);

    @Autowired
    private NumberToKanjiConverter numberToKanjiConverter;

    @ApiOperation(value = "アラビア数字を漢数字に変換する")
    @RequestMapping(method = RequestMethod.GET, value = "{number}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String toKanji(@PathVariable("number") String strNumber) throws BadRequestException {
        LOG.info("receive number: " + strNumber);
        long number = parseAsNumber(strNumber);
        return numberToKanjiConverter.toKanji(number);
    }

    private long parseAsNumber(String strNumber) {
        return Long.valueOf(strNumber);
    }
}
