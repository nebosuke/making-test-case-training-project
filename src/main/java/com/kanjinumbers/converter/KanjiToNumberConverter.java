package com.kanjinumbers.converter;

import org.springframework.stereotype.Service;

@Service
public class KanjiToNumberConverter {

    public long toNumber(String kanji) {
        if (kanji == null) {
            return -1;
        }

        long number = 0L;
        int amount = 0;
        int unit = 0;

        while (kanji.length() > 0) {
            String digit = kanji.substring(0, 1);
            kanji = kanji.substring(1);
            switch (digit) {
            case "兆":
                unit += amount;
                if (unit == 0) {
                    return -1;
                }
                number += (unit * 1_000_000_000_000L);
                unit = 0;
                amount = 0;
                break;
            case "億":
                unit += amount;
                if (unit == 0) {
                    return -1;
                }
                number += (unit * 100_000_000L);
                unit = 0;
                amount = 0;
                break;
            case "万":
                unit += amount;
                if (unit == 0) {
                    return -1;
                }
                number += (unit * 10000L);
                unit = 0;
                amount = 0;
                break;
            case "千":
                if (amount == 0) {
                    return -1;
                }
                unit += (amount * 1000);
                amount = 0;
                break;
            case "百":
                if (amount == 0) {
                    return -1;
                }
                unit += (amount * 100);
                amount = 0;
                break;
            case "拾":
                if (amount == 0) {
                    return -1;
                }
                unit += (amount * 10);
                amount = 0;
                break;
            default:
                int n = digitToNumber(digit);
                if (n < 0) {
                    return -1;
                }
                amount = n > 0 ? n : 0;
            }
        }

        number += unit;
        number += amount;

        return number;
    }

    private int digitToNumber(String digit) {
        for (int i = 0; i < Constants.DIGIT.length; i++) {
            if (Constants.DIGIT[i].equals(digit)) {
                return i;
            }
        }
        return -1;
    }
}
