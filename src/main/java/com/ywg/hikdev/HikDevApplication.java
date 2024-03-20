package com.ywg.hikdev;

import com.ywg.hikdev.util.SdkUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ywg
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class HikDevApplication {

    public static void main(String[] args) {
        SdkUtil.initSdk();
        SpringApplication.run(HikDevApplication.class, args);
    }
}
