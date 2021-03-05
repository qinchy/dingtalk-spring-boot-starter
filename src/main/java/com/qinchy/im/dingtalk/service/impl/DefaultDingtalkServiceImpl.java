package com.qinchy.im.dingtalk.service.impl;

import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.qinchy.im.dingtalk.bean.DingtalkLinkMsg;
import com.qinchy.im.dingtalk.bean.DingtalkMarkdownMsg;
import com.qinchy.im.dingtalk.service.DingtalkService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: qinchy
 * @Date: 2020/7/23 18:18
 * @Description: ${description}
 */
public class DefaultDingtalkServiceImpl implements DingtalkService {

    @Autowired
    private DingTalkClient dingTalkClient;

    public DefaultDingtalkServiceImpl(DingTalkClient dingTalkClient) {
        this.dingTalkClient = dingTalkClient;
    }

    @Override
    public OapiRobotSendResponse sendTextMsg(String textMsg) throws ApiException {
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(textMsg);
        request.setText(text);

        return dingTalkClient.execute(request);
    }

    @Override
    public OapiRobotSendResponse sendLinkMsg(DingtalkLinkMsg linkMsg) throws ApiException {
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("link");
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setMessageUrl(linkMsg.getMessageUrl());
        link.setPicUrl(linkMsg.getPicUrl());
        link.setTitle(linkMsg.getTitle());
        link.setText(linkMsg.getTitle());

        request.setLink(link);

        return dingTalkClient.execute(request);
    }

    @Override
    public OapiRobotSendResponse sendMarkdownMsg(DingtalkMarkdownMsg markdownMsg) throws ApiException {
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle(markdownMsg.getTitle());
        markdown.setText(markdownMsg.getText());
        request.setMarkdown(markdown);

        return dingTalkClient.execute(request);
    }
}
