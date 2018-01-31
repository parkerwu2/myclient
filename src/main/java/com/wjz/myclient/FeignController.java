package com.wjz.myclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wjz.myclient.entity.TestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jingzhi.wu on 2018/1/26.
 */
@RestController
public class FeignController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getOrder2",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hiError")
    public String getUser(@RequestParam(value="orderNo", required = true)String orderNo){
        return orderService.queryOrderByNo(orderNo);
    }

    public String hiError(@RequestParam(value="orderNo", required = true)String orderNo) {
        return "orderNo:"+ orderNo +" query failed!";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "testError")
    public String test(@Valid TestParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> ls = bindingResult.getAllErrors();
            return ls.get(0).getDefaultMessage();
        }
        return "ok";
    }

    public String testError(@Valid TestParam param, BindingResult bindingResult) {
        return bindingResult.getAllErrors().get(0).getCodes()[0];
    }
}
