package com.ywg.hikdev.annotation.aspect;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSONObject;
import com.ywg.hikdev.entity.HikDevResponse;
import com.ywg.hikdev.util.ConfigJsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ywg
 * @date 2024-3-20 11:03
 */
@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class CheckDeviceLoginAspect extends BaseAspectSupport {
    @Pointcut("execution(* com.ywg.hikdev.controller.*.*(..)) && @annotation(com.ywg.hikdev.annotation.CheckDeviceLogin)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        JSONObject parameter = resolveParameter(point);
        String ip = parameter.getString("ipv4Address");
        if (StrUtil.isNotBlank(ip)) {
            Integer longUserId = ConfigJsonUtil.getDeviceSearchInfoByIp(ip).getLoginId();
            if (null == longUserId || longUserId < 0) {
                return new HikDevResponse().err("接口检查: 设备状态未注册");
            }
        } else {
            return new HikDevResponse().err("接口检查: 缺少参数 ipv4Address");
        }
        return point.proceed();
    }
}
