背景
目前业务系统产生的异常或者错误，无法迅速感知并通知给运维人员，给业务的恢复带来了一定的滞后性。期望在关紧业务出错时，能够及时的通知到运维人员，减少客户的感知，把影响降到最低。

业务分析
目前钉钉是业界使用比较频繁的IM工具，咱们也将钉钉作为办公沟通工具。如果在业务出现异常时，能通过钉钉实时告警出来，则能节省不少时间。

实现思路
业务系统在捕获到关键异常，比如数据库连接断开、访问开放平台接口导致业务无法进行下去，等一些影响关键业务的异常时，捕获并抛出特定异常，程序中不要处理这个特定异常，由全局的异常处理类来处理，在全局异常处理类中集成钉钉机器人功能，将异常信息通知到钉钉，相关责任人接收到消息后人工介入。

接入指南
基于以上需求，开发了dingtalk-spring-boot-starter功能，负责处理钉钉接入和全局异常处理功能。

        <dependency>
            <groupId>com.qinchy.im</groupId>
            <artifactId>dingtalk-spring-boot-starter</artifactId>
            <version>2.0-SNAPSHOT</version>
        </dependency>
然后在application.yml中指定钉钉机器人的地址

dingtalk:
webhook:
address:
DEFAULT: ${access_token_1}
SG: ${access_token_2}
MALL: ${access_token_3}
在业务代码会出现影响系统核心业务的地方，抛出CoreBizException，指定错误代码，错误级别，错误信息

        throw new CoreException(ErrorCode.DATABASE_CONNECT_ERROR,
                ErrorLevel.EMERGENCY,"出现数据库断开连接，请马上处理！");
通过以上三个步骤，业务侧即实现了告警信息的钉钉通知。

原理解析

![pom.jpg](http://192.168.1.88:8090/download/attachments/25724161/pom.jpg?version=1&modificationDate=1596718198000&api=v2)


其中：

dingtalk-spring-boot-starter：实现如下功能：

自动解析application.yml中配置的dingtalk.webhook.address，并自动配置DingtalkClient。

基于DingtalkClient自动配置DingtalkService，在DingtalkService中组装消息（文本消息，连接消息，MarkDown消息）并发送。

全局异常处理功能。捕获业务侧抛过来的DingtalkNotifyException，提取异常中的errorCode、errorLevel、message，然后组装文本消息后调用上述DingtalkService实现钉钉消息推送。

异常抛出原则
因此处抛出的异常会对接钉钉机器人，而钉钉机器人的消息上限是20条/分，故这里只应该抛出影响系统运行的关键异常，对于业务异常则此场景不适用。

在Controller层不应对DingtalkNotifyException进行Catch处理，否则外层无法感知系统出现了异常。

异常枚举汇总
DATABASE_CONNECT_ERROR("1001", "数据库链接失败"),
OPEN_CALL_FAIL("1002", "开放平台调用错误"),
OPEN_GET_TOKEN_FAIL("1003", "开放平台获取TOKEN失败"),
ES_REQUEST_DATA_ERROR("1004","ES请求数据异常"),
RDS_REQUEST_DATA_ERROR("1005","Rds请求数据异常"),
WEIXIN_CALL_FAIL("1006","微信接口调用错误"),