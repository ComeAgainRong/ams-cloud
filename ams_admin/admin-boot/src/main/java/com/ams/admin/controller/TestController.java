package com.ams.admin.controller;

import com.ams.common.result.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : { TestController }
 * @Author : {whisper}
 * @Date : {Created in 20:57 2022/2/26}
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test1")
    public R test(){
        return R.ok("测试一下");
    }
}
