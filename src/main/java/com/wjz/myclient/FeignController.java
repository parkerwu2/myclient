package com.wjz.myclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jingzhi.wu on 2018/1/26.
 */
@RestController
public class FeignController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getOrder2",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "hiError")
    public String getUser(@RequestParam(value="orderNo", required = true)String orderNo){
        return orderService.queryOrderByNo(orderNo);
    }

    public String hiError(@RequestParam(value="orderNo", required = true)String orderNo) {
        return "orderNo:"+ orderNo +" query failed!";
    }
}
