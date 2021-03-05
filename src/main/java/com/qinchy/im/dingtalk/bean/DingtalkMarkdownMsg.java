package com.qinchy.im.dingtalk.bean;

/**
 * @Author: qinchy
 * @Date: 2020/7/23 18:11
 * @Description: 钉钉markdown消息
 */
public class DingtalkMarkdownMsg {
    private String title;
    private String text;

    public DingtalkMarkdownMsg() {
    }

    public DingtalkMarkdownMsg(String title, String text) {
        this.title = title;
        this.text = text;
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

        DingtalkMarkdownMsg that = (DingtalkMarkdownMsg) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(title, that.title)
                .append(text, that.text)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(title)
                .append(text)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "DingtalkMarkdownMsg{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
