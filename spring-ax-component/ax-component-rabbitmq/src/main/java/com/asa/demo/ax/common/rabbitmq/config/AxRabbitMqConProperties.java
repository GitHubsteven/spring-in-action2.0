package com.asa.demo.ax.common.rabbitmq.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ToString
@ConfigurationProperties("ax.rabbitmq.config")
public class AxRabbitMqConProperties {
    /**
     * 消息shutdown场合的timeout
     */
    private int shutdownTimeout = 1000;

    /**
     * 是否本地环境
     */
    private boolean local = true;

    /**
     * 是否初始化时启动消息的任务配置
     */
    private boolean initConsumerEnabled = false;


    /**
     * 是否可以采番（为TRUE的场合下isSequence才起作用）
     */
    private boolean enableSequence = false;

    /**
     * 是否默认的场合下采番
     */
    private boolean isSequence = true;

    /**
     * 事物的场合下发生消息的类型 在数据提交之后发送消息
     */
    private MqSendTransactionType sendTransactionType = MqSendTransactionType.COMMIT;

}
