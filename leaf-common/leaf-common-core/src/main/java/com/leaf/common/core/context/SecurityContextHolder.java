package com.leaf.common.core.context;

import cn.hutool.core.convert.Convert;
import com.leaf.common.core.constant.SecurityConstants;

/**
 * 获取当前线程变量中的 用户id、用户名称、Token等信息
 * 注意： 必须在网关通过请求头的方法传入，同时在HeaderInterceptor拦截器设置值。 否则这里无法获取
 *
 * @author yezi
 * @date 2023/7/26 21:58
 */
public class SecurityContextHolder extends ThreadContextHolder {

    /**
     * 获取当前线程的用户Id
     *
     * @return 用户Id
     */
    public static Long getUserId() {
        return Convert.toLong(get(SecurityConstants.DETAILS_USER_ID), 0L);
    }

    /**
     * 设置当前线程的用户Id
     *
     * @param account 用户Id
     */
    public static void setUserId(String account) {
        set(SecurityConstants.DETAILS_USER_ID, account);
    }

    /**
     * 获取当前线程的用户名
     *
     * @return 用户名
     */
    public static String getUserName() {
        return get(SecurityConstants.DETAILS_USERNAME);
    }

    /**
     * 设置当前线程的用户名
     *
     * @param username 用户名
     */
    public static void setUserName(String username) {
        set(SecurityConstants.DETAILS_USERNAME, username);
    }

    /**
     * 获取当前线程的用户key
     *
     * @return 用户key
     */
    public static String getUserKey() {
        return get(SecurityConstants.USER_KEY);
    }

    /**
     * 设置当前线程的用户key
     *
     * @param userKey 用户key
     */
    public static void setUserKey(String userKey) {
        set(SecurityConstants.USER_KEY, userKey);
    }

    /**
     * 获取当前线程的角色权限
     *
     * @return 角色权限
     */
    public static String getPermission() {
        return get(SecurityConstants.ROLE_PERMISSION);
    }

    /**
     * 设置当前线程的角色权限
     *
     * @param permissions 角色权限
     */
    public static void setPermission(String permissions) {
        set(SecurityConstants.ROLE_PERMISSION, permissions);
    }
}
