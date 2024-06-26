package com.ywg.hikdev.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ywg.hikdev.annotation.CheckDeviceLogin;
import com.ywg.hikdev.entity.HikDevResponse;
import com.ywg.hikdev.entity.param.AccessControlUser;
import com.ywg.hikdev.service.IHikCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门禁 以卡为中心
 * @author ywg
 * @date 2024-3-7 16:55
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/access/card")
@Deprecated
public class AccessCardController {
    private final IHikCardService hikCardService;

    /**
     * 设置
     */
    @GetMapping("setCartTemplate")
    @Deprecated
    public void setCartTemplate(Integer planTemplateNumber, String ip) {
        this.hikCardService.setCartTemplate(planTemplateNumber, ip);
    }

    /**
     * 根据设备IP查询所有卡信息
     *
     * @param ip
     * @return
     */
    @Deprecated
    @GetMapping("selectCardInfoByDeviceIp")
    public JSONObject selectCardInfoByDeviceIp(String ip) {
        return this.hikCardService.selectCardInfoByDeviceIp(ip);
    }

    /**
     * 下发卡信息
     * @param ipv4Address
     * @param accessControlUser
     * @return
     */
    @Deprecated
    @PostMapping("addCard/{ipv4Address}")
    public JSONObject addCard(@PathVariable String ipv4Address, @RequestBody AccessControlUser accessControlUser) {
        return this.hikCardService.addCard(ipv4Address, accessControlUser);
    }

    /**
     * 批量下发卡信息
     *
     * @param jsonObject 卡信息
     * @return
     */
    @Deprecated
    @PostMapping("distributeMultiCard")
    public JSONObject distributeMultiCard(@RequestBody JSONObject jsonObject) {
        return this.hikCardService.distributeMultiCard(jsonObject);
    }

    /**
     * 批量下发人脸
     *
     * @param jsonObject 人脸信息
     * @return
     */
    @Deprecated
    @PostMapping("distributeMultiFace")
    public JSONObject distributeMultiFace(@RequestBody JSONObject jsonObject) {
        return this.hikCardService.distributeMultiFace(jsonObject);
    }

    /**
     * 根据卡号删除人脸
     *
     * @param jsonObject
     * @return
     */
    @Deprecated
    @PostMapping("deleteFaceByCardNo")
    public JSONObject deleteFaceByCardNo(@RequestBody JSONObject jsonObject) {
        return this.hikCardService.deleteFaceByCardNo(jsonObject);
    }

    /**
     * 根据卡号删除卡信息
     *
     * @param jsonObject
     * @return
     */
    @Deprecated
    @PostMapping("deleteCardByCardNo")
    public JSONObject deleteCardByCardNo(@RequestBody JSONObject jsonObject) {
        return this.hikCardService.deleteCardByCardNo(jsonObject);
    }
}
