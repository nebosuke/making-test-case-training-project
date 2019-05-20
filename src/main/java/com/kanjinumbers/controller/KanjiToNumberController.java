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
import com.kanjinumbers.converter.KanjiToNumberConverter;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/kanji2number")
public class KanjiToNumberController {

    private static final Logger LOG = LoggerFactory.getLogger(NumberToKanjiController.class);

    @Autowired
    private KanjiToNumberConverter kanjiToNumberConverter;

    @ApiOperation(value = "漢数字をアラビア数字に変換する")
    @RequestMapping(method = RequestMethod.GET, value = "{kanji}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String toKanji(@PathVariable("kanji") String kanji) throws BadRequestException {
        LOG.info("receive kanji: " + kanji);
        return String.valueOf(kanjiToNumberConverter.toNumber(kanji));
    }

}
