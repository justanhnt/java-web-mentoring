package com.mentoring.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionCodeHelper {

    private static final Map<Integer, String> VN_CODE_DICTIONARY = new HashMap<>();
    private static final Map<Integer, String> EN_CODE_DICTIONARY = new HashMap<>();

    static {
        VN_CODE_DICTIONARY.put(0x01, "Đẹp trai quá, nên throws exception");
        VN_CODE_DICTIONARY.put(0x02, "Chưa có người yêu, nên throws exception");
    }

    static {
        EN_CODE_DICTIONARY.put(0x01, "Too handsome, so throws exception");
        EN_CODE_DICTIONARY.put(0x02, "Still single, so throws exception");
    }

    static String translateToLocal(int code, Country country) {
        switch (country) {
            case VN:
                return VN_CODE_DICTIONARY.get(code);
            case EN:
                return EN_CODE_DICTIONARY.get(code);
            default:
                return "Other (" + code + ")";
        }
    }
}
