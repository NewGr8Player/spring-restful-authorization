package com.scienjus.controller;

import com.scienjus.authorization.annotation.Authorization;
import com.scienjus.model.ResultModel;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NewGr8Player
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.POST)
    @Authorization
    @ApiOperation(value = "测试案例")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content", value = "内容", required = true, dataType = "string", paramType = "header")
    })
    public ResponseEntity<ResultModel> test(@RequestParam String content) {
        return new ResponseEntity<>(ResultModel.ok("成功取得用户权限传入数据为：" + content), HttpStatus.OK);
    }
}
