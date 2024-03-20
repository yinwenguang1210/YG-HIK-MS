package com.ywg.hikdev.mqtt;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ywg.hikdev.util.ConfigJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

/**
 * @author ywg
 * @date 2021-5-10 14:47
 */
@Slf4j
@Component
public class MqttConnectClient {

    private MqttClient mqttClient;

    public void initMqttClient() {
        try {
            this.mqttClient = new MqttClient(ConfigJsonUtil.getMqttConfig().getBroker(), RandomUtil.randomString(16), new MemoryPersistence());
            //设置回调
            this.mqttClient.setCallback(new OnMessageCallback(this));
        } catch (MqttException e) {
            log.info("Mqtt初始化失败");
        }
    }

    public void mqttConnect() {
        try {
            Thread.sleep(5 * 1000L);
            log.info("Mqtt开始连接");
            // MQTT 连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName(ConfigJsonUtil.getMqttConfig().getUsername());
            connOpts.setPassword(ConfigJsonUtil.getMqttConfig().getPassword().toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);
            // 建立连接
            this.mqttClient.connect(connOpts);
            log.info("Mqtt 连接成功");
            this.subscribe(ConfigJsonUtil.getMqttConfig().getSubTopic());
            log.info("Mqtt 订阅成功：{}", ConfigJsonUtil.getMqttConfig().getSubTopic());
        } catch (MqttException me) {
            log.error("连接mqtt异常,重新连接。");
            this.mqttConnect();
        } catch (InterruptedException e) {
            log.error("连接mqtt,睡眠异常");
        }

    }

    public void subscribe(String subTopic) {
        try {
            // 订阅
            this.mqttClient.subscribe(subTopic);
        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

    /**
     * 发布消息 消息发布所需参数
     */
    public void publish(String content) {
        try {
            JSONObject jsonObject = JSON.parseObject(content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(ConfigJsonUtil.getMqttConfig().getQos());
            this.mqttClient.publish(ConfigJsonUtil.getMqttConfig().getPubTopic(), message);
//            log.info("Message published");
        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

    public void close() {
        try {
            this.mqttClient.disconnect();
//            log.info("Mqtt Disconnected");
            this.mqttClient.close();
//            log.info("Mqtt Closed");
        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

}
