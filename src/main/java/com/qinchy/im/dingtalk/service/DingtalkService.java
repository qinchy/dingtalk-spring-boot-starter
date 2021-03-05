package com.qinchy.im.dingtalk.service;

import com.dingtalk.api.response.OapiRobotSendResponse;
import com.qinchy.im.dingtalk.bean.DingtalkLinkMsg;
import com.qinchy.im.dingtalk.bean.DingtalkMarkdownMsg;
import com.taobao.api.ApiException;

/**
 * @Author: qinchy
 * @Date: 2020/7/23 17:56
 * @Description: ${description}
 */
public interface DingtalkService {

    /**
     * 发送文本消息
     *
     * @param textMsg
     * @return
     */
    OapiRobotSendResponse sendTextMsg(String textMsg) throws ApiException;

    /**
     * 发送连接消息
     *
     * @param linkMsg
     * @return
     */
    OapiRobotSendResponse sendLinkMsg(DingtalkLinkMsg linkMsg) throws ApiException;

    /**
     * 发送markdown消息
     * @param markdownMsg
     * @return
     */
    OapiRobotSendResponse sendMarkdownMsg(DingtalkMarkdownMsg markdownMsg) throws ApiException;
}
