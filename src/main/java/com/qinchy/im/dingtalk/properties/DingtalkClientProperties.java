package com.qinchy.im.dingtalk.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: qinchy
 * @Date: 2020/7/23 14:25
 * @Description: 从配置文件获取钉钉webhook的地址
 */
@ConfigurationProperties("dingtalk.webhook")
public class DingtalkClientProperties {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
