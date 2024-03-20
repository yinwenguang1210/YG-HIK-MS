package com.ywg.hikdev.controller;

import com.ywg.hikdev.entity.HikDevResponse;
import com.ywg.hikdev.mqtt.MqttConfig;
import com.ywg.hikdev.mqtt.MqttConnectClient;
import com.ywg.hikdev.util.ConfigJsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mqtt")
@RequiredArgsConstructor
public class MqttController {
    private final MqttConnectClient mqttConnectClient;

    @GetMapping("init")
    public HikDevResponse initMqttClient(String broker, String subTopic, String pubTopic, Integer qos, String username, String password) {
        MqttConfig mqttConfig = new MqttConfig();
        mqttConfig.setBroker(broker);
        mqttConfig.setUsername(username);
        mqttConfig.setSubTopic(subTopic);
        mqttConfig.setPubTopic(pubTopic);
        mqttConfig.setQos(qos);
        mqttConfig.setPassword(password);
        ConfigJsonUtil.setMqttConfig(mqttConfig);
        this.mqttConnectClient.initMqttClient();
        this.mqttConnectClient.mqttConnect();
        return new HikDevResponse().ok("init完成✅");
    }

    @GetMapping("setProjectId")
    public HikDevResponse setProjectId(String projectId) {
        ConfigJsonUtil.setProjectId(projectId);
        return new HikDevResponse().ok("设置项目ID完成✅");
    }
}
