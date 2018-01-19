package com.vm.frontend.util;


import com.vm.base.util.CommonUtil;
import com.vm.base.util.DateUtil;
import com.vm.redis.repository.RedisRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by ZhangKe on 2018/1/17.
 * 记录<token,userId>的键值对,token被记录则代表在线
 */
@Component
public class SessionManager extends CommonUtil {

    private final static Long timeout = FrontendServerConfig.VM_USER_SESSION_TIMEOUT;

    @Autowired
    private RedisRepository redisRepository;

    private static RedisRepository redisRepositoryCache;

    @PostConstruct
    public void init() {
        this.redisRepositoryCache = this.redisRepository;
    }

    /**
     * 清空SessionMnanger
     *
     * @return
     */
//    public final static boolean clearSessionManager() {
//        redisRepositoryCache.hmset(REDIS_KEY_OF_ONLINE_USER_PREFIX, Maps.newHashMap());
//        return true;
//    }
    private static String generateToken() {
        return CommonUtil.uuid();
    }

    /**
     * 清空session
     *
     * @param token
     * @return
     */
    public static Object clearSession(String token) {
        if (null == token) {
            return true;
        }
        redisRepositoryCache.del(Lists.newArrayList(token).toString());
        return true;
    }

    /**
     * 获取在线用户id
     *
     * @param token
     * @return
     */
    public static Object getOnlineUserId(String token) {
        if (null == token) {
            return null;
        }
        UserInfo tokenInfo = (UserInfo) redisRepositoryCache.get(token);

        if (tokenInfo == null) {
            return null;
        }
        return tokenInfo.getId();
    }

    /**
     * 获取在线用户信息
     *
     * @param token
     * @return
     */
    public static Object getOnlineUserInfo(String token) {
        if (null == token) {
            return null;
        }
        UserInfo tokenInfo = (UserInfo) redisRepositoryCache.get(token);

        return tokenInfo;
    }

    /**
     * 用户登录,储存器在线id
     *
     * @return
     */
    public static String userLogin(UserInfo userInfo) throws Exception {
        if (userInfo == null) {
            throw new Exception("SessionManager token info is null ! userInfo is : " + userInfo);
        }
        userInfo = rebuildUserInfo(userInfo);
        String token = generateToken();
        boolean res = redisRepositoryCache.set(token, userInfo, timeout);
        return token;
    }

    private static UserInfo rebuildUserInfo(UserInfo userInfo) {
        userInfo.setLoginTime(DateUtil.unixTime().intValue());
        return userInfo;
    }

    /**
     * 用户退出
     *
     * @param token
     * @return
     */
    public static boolean userLogout(String token) {
        return (boolean) SessionManager.clearSession(token);
    }


    public static class UserInfo implements Serializable {
        private Long id;
        private String username;
        private Integer loginTime;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Integer loginTime) {
            this.loginTime = loginTime;
        }
    }
}
