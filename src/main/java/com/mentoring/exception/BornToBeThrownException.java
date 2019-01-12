package com.mentoring.exception;

public class BornToBeThrownException extends Exception {

    private final int code;

    public BornToBeThrownException(int code) {
        this.code = code;
//        super(this.toString());
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("code = ").append(String.format("0x%02X", code));
        sb.append(", ");
        sb.append("local meaning = ").append(ExceptionCodeHelper.translateToLocal(code, Country.getDefaultCountry()));
        return sb.toString();
    }
}
