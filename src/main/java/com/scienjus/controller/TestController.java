package com.scienjus.controller;

import com.scienjus.authorization.annotation.Authorization;
import com.scienjus.authorization.manager.TokenManager;
import com.scienjus.domain.User;
import com.scienjus.model.ResultModel;
import com.scienjus.repository.UserRepository;
import com.scienjus.util.IterableUtils;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>测试Controller</p>
 *
 * @author NewGr8Player
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "测试案例")
    public ResponseEntity<ResultModel> test(@RequestParam String context) {
        return new ResponseEntity<>(ResultModel.ok("测试成功，传入值为：" + context), HttpStatus.OK);
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @Authorization
    @ApiOperation(value = "list方法", notes = "列出当前所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "权限Token串", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<ResultModel> list() {
        List<User> userList = IterableUtils.toList(this.userRepository.findAll());
        return new ResponseEntity<>(ResultModel.ok(userList), HttpStatus.OK);
    }

}
