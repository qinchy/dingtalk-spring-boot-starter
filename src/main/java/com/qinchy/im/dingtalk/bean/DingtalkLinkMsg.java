package com.qinchy.im.dingtalk.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @Author: qinchy
 * @Date: 2020/7/23 18:07
 * @Description: 钉钉链接消息对象
 */
public class DingtalkLinkMsg {
    private String messageUrl;
    private String picUrl;
    private String title;
    private String text;

    public DingtalkLinkMsg() {
    }

    public DingtalkLinkMsg(String messageUrl, String picUrl, String title, String text) {
        this.messageUrl = messageUrl;
        this.picUrl = picUrl;
        this.title = title;
        this.text = text;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DingtalkLinkMsg that = (DingtalkLinkMsg) o;

        return new EqualsBuilder()
                .append(messageUrl, that.messageUrl)
                .append(picUrl, that.picUrl)
                .append(title, that.title)
                .append(text, that.text)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(messageUrl)
                .append(picUrl)
                .append(title)
                .append(text)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "DingtalkLinkMsg{" +
                "messageUrl='" + messageUrl + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
