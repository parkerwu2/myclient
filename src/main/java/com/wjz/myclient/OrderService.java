package com.wjz.myclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jingzhi.wu on 2018/1/26.
 */
@FeignClient("mySpringBootLearn1")
public interface OrderService {

    @RequestMapping(value = "/order/queryOrderByNo", method = RequestMethod.POST)
    String queryOrderByNo(@RequestParam(value = "orderNo") String orderNo);
}
