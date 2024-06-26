package com.ywg.hikdev.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSONObject;
import com.ywg.hikdev.entity.access.AccessPeople;
import com.ywg.hikdev.entity.QueryRequest;
import com.ywg.hikdev.service.IHikUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 门禁 以人为中心
 *
 * @author ywg
 * @date 2024-3-7 16:57
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/access/people")
@Deprecated
public class AccessPeopleController {

    private final IHikUserService hikUserService;

    /**
     * 查询门禁设备中用户数据
     * 分页从0开始
     *
     * @param ip           设备ID
     * @param employeeNos  用户ID employeeNo
     * @param queryRequest 分页数据
     * @return
     */
    @Deprecated
    @GetMapping("searchPeoples/{ip}")
    public JSONObject searchPeoples(@PathVariable String ip, String employeeNos, QueryRequest queryRequest) {
        String[] ids = {};
        if (StrUtil.isNotBlank(employeeNos)) {
            ids = employeeNos.split(",");
        }
        return this.hikUserService.searchUserInfo(ip, ids, queryRequest);
    }

    /**
     * 根据工号查询人脸
     *
     * @param ip     设备IP
     * @param people employeeNo
     * @return
     */
    @Deprecated
    @GetMapping("searchPeopleFace/{ip}")
    public JSONObject searchPeopleFace(@PathVariable String ip, AccessPeople people) {
        return this.hikUserService.searchFaceInfo(ip, people);
    }

    /**
     * 新增用户
     *
     * @param ip     设备IP
     * @param people 工号和真实姓名
     * @return
     */
    @Deprecated
    @PostMapping("addPeople/{ip}")
    public JSONObject addPeople(@PathVariable String ip, @RequestBody AccessPeople people) throws UnsupportedEncodingException, InterruptedException {
        return this.hikUserService.addUserInfo(ip, people);
    }

    /**
     * 修改用户
     *
     * @param ip     设备IP
     * @param people 工号和真实姓名
     * @return
     */
    @Deprecated
    @PostMapping("modifyPeople/{ip}")
    public JSONObject modifyPeople(@PathVariable String ip, @RequestBody AccessPeople people) {
        return this.hikUserService.modifyUserInfo(ip, people);
    }

    /**
     * 批量下发用户
     *
     * @param ip         设备IP
     * @param peopleList 用户列表
     * @return
     */
    @Deprecated
    @PostMapping("addMultiPeople/{ip}")
    public JSONObject addMultiPeople(@PathVariable String ip, @RequestBody List<AccessPeople> peopleList) throws UnsupportedEncodingException, InterruptedException {
        return this.hikUserService.addMultiUserInfo(ip, peopleList);
    }

    /**
     * 下发用户人脸
     *
     * @param ip     设备IP
     * @param people 用户列表
     * @return
     */
    @Deprecated
    @PostMapping("addPeopleFace/{ip}")
    public JSONObject addPeopleFace(@PathVariable String ip, @RequestBody AccessPeople people) {
        return this.hikUserService.addPeopleFace(ip, people);
    }

    /**
     * 批量下发用户人脸
     *
     * @param ip         设备IP
     * @param peopleList 用户列表
     * @return
     */
    @Deprecated
    @PostMapping("addMultiPeopleFace/{ip}")
    public JSONObject addMultiPeopleFace(@PathVariable String ip, @RequestBody List<AccessPeople> peopleList) {
        return this.hikUserService.addMultiFace(ip, peopleList);
    }

    /**
     * 根据工号批量删除人脸
     *
     * @param ip          设备IP
     * @param employeeIds 用户ID列表 employeeIds
     * @return
     */
    @Deprecated
    @PostMapping("delMultiPeopleFace/{ip}")
    public JSONObject delMultiPeopleFace(@PathVariable String ip, @RequestParam String employeeIds) {
        String[] ids = employeeIds.split(",");
        return this.hikUserService.delFaceInfo(ip, ids);
    }

    /**
     * 根据工号批量删除用户
     *
     * @param ip          设备IP
     * @param employeeIds 用户ID列表
     * @return
     */
    @Deprecated
    @PostMapping("delMultiPeople/{ip}")
    public JSONObject delMultiPeople(@PathVariable String ip, @RequestParam String employeeIds) {
        String[] ids = employeeIds.split(",");
        return this.hikUserService.delUserInfo(ip, ids);
    }
}
