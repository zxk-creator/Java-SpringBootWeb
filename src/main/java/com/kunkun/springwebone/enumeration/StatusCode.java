package com.kunkun.springwebone.enumeration;

public enum StatusCode {
    // 成功码
    SUCCESS,
    // 错误码
    // 登录相关
    EMPTY_USERNAME_OR_PASSWORD,
    INVALID_USERNAME_OR_PASSWORD,
    // 员工管理相关
    INVALID_PARAM,
    // 通用
    OPERATION_FAILED,
}
