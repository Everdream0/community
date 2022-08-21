package com.nowcoder.community.entity;

import java.util.Date;

public class Message {

    private int id;
    // 发送方,系统用户是1
    private int fromId;
    // 接收方
    private int toId;
    // 标记会话111_112,小的id放前面
    private String conversationId;
    private String content;
    // 状态，0表示未读，1表示已读，2表示删除
    private int status;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", conversationId=" + conversationId +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
