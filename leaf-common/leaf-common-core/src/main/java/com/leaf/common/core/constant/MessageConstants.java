package com.leaf.common.core.constant;

/**
 * 通用响应信息常量
 *
 * @author yezi
 * @date 2023/7/26 22:26
 */
public class MessageConstants {

    public static final String LOGIN_SUCCESS = "登录成功!";
    public static final String USERNAME_PASSWORD_ERROR = "用户名或密码错误!";
    public static final String CAPTCHA_NOT_CORRECT = "验证码不正确";
    public static final String ACCESS_FORBIDDEN_BACK_SYSTEM = "该账号不具备后台访问权限";
    public static final String CREDENTIALS_EXPIRED = "该账户的登录凭证已过期，请重新登录!";
    public static final String ACCOUNT_DISABLED = "该账户已被禁用，请联系管理员!";
    public static final String ACCOUNT_LOCKED = "该账号已被锁定，请联系管理员!";
    public static final String ACCOUNT_EXPIRED = "该账号已过期，请联系管理员!";
    public static final String PERMISSION_DENIED = "没有访问权限，请联系管理员!";
    public static final String DENIED_OPERATION_PERMISSION = "没有操作权限，请联系管理员!";
    public static final String TENANT_INVALID = "无效的租户ID";
    public static final String ACCOUNT_INVALID = "无效的用户ID";
    public static final String TENANT_ACCESS_DENIED = "无此租户权限";
    public static final String AUTH_SERVER_ERROR = "远程服务器错误！";
    public static final String CLIENT_AUTH_FAILED = "客户端认证失败！";

    /**
     * 默认成功消息
     */
    public static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认失败消息
     */
    public static final String DEFAULT_FAILURE_MESSAGE = "操作失败";
    /**
     * 未知错误
     */
    public static final String DEFAULT_FAILURE_RESOLVE = "未知错误，请联系管理员！！！";

    /**
     * 页面不存在
     */
    public static final String NOT_PAGE_RESOLVE = "标签页不存在，请关闭此标签页并清除缓存！！！";

}
