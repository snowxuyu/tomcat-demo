package org.snow.tomcat.demo.controller;

import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snow.tomcat.demo.dao.SnowSlakeDao;
import org.snow.tomcat.demo.entity.SnowSlake;
import org.snow.tomcat.demo.utils.SnowflakeIdWorker;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * date: 2018/10/18 20:29
 * author: snowxuyu
 * describe:
 */
@RestController
@RequestMapping("/api/snowslake")
public class SnowSlakeController {

    private Logger logger = LoggerFactory.getLogger(SnowSlakeController.class);

    @Resource
    private ThreadPoolTaskExecutor threadPool;

    @Resource
    SnowSlakeDao snowSlakeDao;

    @RequestMapping("/generateUid")
    public ResponseEntity generateUid() {
        logger.info(">>>>> begin");
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j <= 1000; j++) {
                    int randomInt = random.nextInt(30);
                    SnowSlake snowSlake = new SnowSlake();
                    snowSlake.setId(null);
                    snowSlake.setUnId(new SnowflakeIdWorker(randomInt, 20).nextId());
                    snowSlakeDao.insert(snowSlake);
                    snowSlake = null;
                }
            });
        }
        return BaseResponse.buildSuccess("success");
    }
}
