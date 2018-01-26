package com.wjz.myclient;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String getUser(@RequestParam(value="orderNo", required = true)String orderNo){
        return orderService.queryOrderByNo(orderNo);
    }
}
