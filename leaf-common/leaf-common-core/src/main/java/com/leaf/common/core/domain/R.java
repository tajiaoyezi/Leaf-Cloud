package com.leaf.common.core.domain;

import com.leaf.common.core.constant.Constants;
import com.leaf.common.core.constant.MessageConstants;
import com.leaf.common.core.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 响应信息实体
 *
 * @author yezi
 * @date 2023/7/26 22:12
 */
@Setter
@Getter
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;

    /**
     * 响应码
     */
    private long code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 响应数据
     */
    private T data;

    private R(ResultCode resultCode) {
        this(resultCode, resultCode.getMessage(), null);
    }

    private R(ResultCode resultCode, String message) {
        this(resultCode, message, null);
    }

    private R(ResultCode resultCode, T data) {
        this(resultCode, resultCode.getMessage(), null);
    }

    private R(ResultCode resultCode, String message, T data) {
        this(resultCode.getCode(), message, data);
    }

    protected R(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = ResultCode.SUCCESS.getCode() == code;
    }

    /**
     * 成功返回结果
     *
     * @param data 数据
     */
    public static <T> R<T> data(T data) {
        return data(data, ResultCode.SUCCESS.getMessage());
    }

    /**
     * 成功返回结果
     *
     * @param data    数据
     * @param message 自定义响应信息
     */
    public static <T> R<T> data(T data, String message) {
        return data(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 成功返回结果
     *
     * @param data    数据
     * @param code    自定义状态码
     * @param message 自定义响应信息
     */
    public static <T> R<T> data(long code, String message, T data) {
        return new R<>(code, message, data);
    }

    /**
     * 成功返回结果
     *
     * @param message 自定义响应信息
     */
    public static <T> R<T> success(String message) {
        return new R<>(ResultCode.SUCCESS, message);
    }

    /**
     * 成功返回结果
     *
     * @return 默认响应信息
     */
    public static <T> R<T> success() {
        return success(ResultCode.SUCCESS.getMessage());
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码枚举 {@link ResultCode}
     */
    public static <T> R<T> failed(ResultCode errorCode) {
        return new R<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 自定义响应信息
     */
    public static <T> R<T> failed(String message) {
        return new R<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @return 默认响应信息
     */
    public static <T> R<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> R<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> R<T> validateFailed(String message) {
        return new R<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> R<T> unauthorized(T data) {
        return new R<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> R<T> forbidden(T data) {
        return new R<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    /**
     * 判断操作状态
     * <p>
     * flag：true 成功，false 失败
     */
    public static <T> R<T> status(boolean flag) {
        return flag ? success(MessageConstants.DEFAULT_SUCCESS_MESSAGE) : failed(MessageConstants.DEFAULT_FAILURE_MESSAGE);
    }
}
