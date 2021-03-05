package com.qinchy.im.dingtalk.autoconfigure;

import com.dingtalk.api.DingTalkClient;
import com.qinchy.im.dingtalk.service.DingtalkService;
import com.qinchy.im.dingtalk.service.impl.DefaultDingtalkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qinchy
 * @Date: 2020/7/24 9:37
 * @Description: 发送消息服务类自动配置
 */
@Configuration
@ConditionalOnClass(DingtalkService.class)
@ConditionalOnBean(DingTalkClient.class)
public class DingtalkServiceAutoConfigure {

    @Autowired
    private DingTalkClient dingTalkClient;

    @Bean(name = "dingtalkService")
    @ConditionalOnMissingBean
    public DingtalkService dingtalkService() {
        return new DefaultDingtalkServiceImpl(dingTalkClient);
    }
}
