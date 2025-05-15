package com.huy.spring_study.configuration.constant;

public class ErrorMessage {
    ErrorMessage() {
    }
    public static final String PASSWORD_NOT_BLANK = "Password không được để trống";
    public static final String PASSWORD_MIN_LENGTH = "Password phải có ít nhất 6 ký tự";

    public static final String USERNAME_NOT_BLANK = "Username không được để trống";
    public static final String USERNAME_MIN_MAX_LENGTH = "Username phải từ 3-50 ký tự";

    public static final String EMAIL_NOT_BLANK = "Email không được để trống";
    public static final String EMAIL_NOT_VALID = "Email không không hợp lệ";

    public static final String FULL_NAME_NOT_BLANK = "Họ tên không được để trống";
}
