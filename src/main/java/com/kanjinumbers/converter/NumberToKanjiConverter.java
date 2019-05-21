package com.kanjinumbers.converter;

import org.springframework.stereotype.Service;

@Service
public class NumberToKanjiConverter {

    private static final long MAX_NUMBER = 9_999_999_999_999_999L;

    public String toKanji(long number) {
        if (number < 0 || number > MAX_NUMBER) {
            return null;
        }

        if (number == 0) {
            return digitToKanji(0);
        }

        int unit1 = (int) (number % 10000); // なし
        number = (number - unit1) / 10000;
        int unit2 = (int) (number % 10000); // 万
        number = (number - unit2) / 10000;
        int unit3 = (int) (number % 10000); // 億
        number = (number - unit3) / 10000;
        int unit4 = (int) (number % 10000); // 兆

        StringBuilder kanji = new StringBuilder();
        if (unit4 > 0) {
            kanji.append(format10K(unit4))
                    .append("兆");
        }
        if (unit3 > 0) {
            kanji.append(format10K(unit3))
                    .append("億");
        }
        if (unit2 > 0) {
            kanji.append(format10K(unit2))
                    .append("万");
        }
        if (unit1 > 0) {
            kanji.append(format10K(unit1));
        }
        return kanji.toString();
    }

    private String format10K(int unit) {
        // 9999
        // |||`- digit1
        // ||`-- digit2
        // |`--- digit3
        // `---- digit4
        int digit1 = unit % 10;
        unit = (unit - digit1) / 10;
        int digit2 = unit % 10;
        unit = (unit - digit2) / 10;
        int digit3 = unit % 10;
        unit = (unit - digit3) / 10;
        int digit4 = unit % 10;

        StringBuilder kanji = new StringBuilder();
        if (digit4 > 0) {
            kanji.append(digitToKanji(digit4))
                    .append("千");
        }
        if (digit3 > 0) {
            kanji.append(digitToKanji(digit3))
                    .append("百");
        }
        if (digit2 > 0) {
            kanji.append(digitToKanji(digit2))
                    .append("拾");
        }
        if (digit1 > 0) {
            kanji.append(digitToKanji(digit1));
        }

        return kanji.toString();
    }

    private String digitToKanji(int digit) {
        return Constants.DIGIT[digit % 10];
    }
}
