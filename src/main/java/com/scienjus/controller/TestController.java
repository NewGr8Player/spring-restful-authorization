package com.scienjus.controller;

import com.scienjus.model.ResultModel;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试Controller</p>
 * @author NewGr8Player
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "测试案例")
    public ResponseEntity<ResultModel> test(@RequestParam String context) {
        return new ResponseEntity<>(ResultModel.ok("测试成功，传入值为：" + context), HttpStatus.OK);
    }
}
