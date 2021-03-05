package com.qinchy.im.dingtalk.autoconfigure;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.qinchy.im.dingtalk.properties.DingtalkClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qinchy
 * @Date: 2020/7/23 14:35
 * @Description: 钉钉客户端自动配置类
 */
@Configuration
@ConditionalOnClass(DingTalkClient.class)
@EnableConfigurationProperties(DingtalkClientProperties.class)
public class DingtalkClientAutoConfigure {

    @Autowired
    private DingtalkClientProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "dingtalk.webhook", value = "address")
    public DingTalkClient dingTalkClient() {
        return new DefaultDingTalkClient(properties.getAddress());
    }
}
