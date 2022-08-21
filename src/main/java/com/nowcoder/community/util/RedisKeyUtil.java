package com.nowcoder.community.util;

public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    private static final String PREFIX_USER_LIKE = "like:user";
    private static final String PREFIX_FOLLOWEE = "followee";
    private static final String PREFIX_FOLLOWER = "follower";
    private static final String PREFIX_KAPTCHA = "kaptcha";
    private static final String PREFIX_TICKET = "ticket";
    private static final String PREFIX_USER = "user";
    private static final String PREFIX_UV = "uv";
    private static final String PREFIX_DAU = "dau";
    private static final String PREFIX_POST = "post";

    // 某个实体的赞
    // like:entity:entityType: entityId -> set(userId)
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    // 某个用户的赞
    // like:user:userId -> int
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

    // 某个用户关注的实体
    // followee:userId:entityType -> zset(entityId,now)
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    // 某个实体拥有的粉丝
    // follower:entityType:entityId -> zset(userId,now)
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }

    // 登录验证码
    // 传入一个临时凭证存在cookie里用来标识当前的用户
    // kaptcha:owner -> String
    public static String getKaptchaKey(String owner) {
        return PREFIX_KAPTCHA + SPLIT + owner;
    }

    // 登录的凭证
    // ticket:ticket -> LoginTicket
    public static String getTicketKey(String ticket) {
        return PREFIX_TICKET + SPLIT + ticket;
    }

    // 用户
    // user:userId -> User
    public static String getUserKey(int userId) {
        return PREFIX_USER + SPLIT + userId;
    }

    // 单日UV
    // uv:data -> ip HyperLogLog()存储结构
    public static String getUVKey(String date) {
        return PREFIX_UV + SPLIT + date;
    }

    // 区间UV
    // uv:startDate:endDate -> ip
    public static String getUVKey(String startDate, String endDate) {
        return PREFIX_UV + SPLIT + startDate + SPLIT + endDate;
    }

    // 单日活跃用户
    // dau:data -> userId BitMap存储结构
    public static String getDAUKey(String date) {
        return PREFIX_DAU + SPLIT + date;
    }

    // 区间活跃用户
    // dau:startDate:endDate -> userId
    public static String getDAUKey(String startDate, String endDate) {
        return PREFIX_DAU + SPLIT + startDate + SPLIT + endDate;
    }

    // 帖子分数
    // post:score -> set(postId)
    public static String getPostScoreKey() {
        return PREFIX_POST + SPLIT + "score";
    }

    // 热帖二级缓存
    // post:offset:limit -> zset(postId)
    public static String getL2PostKey(Integer offset, Integer limit) {
        return PREFIX_POST + SPLIT + offset + SPLIT + limit;
    }

}
