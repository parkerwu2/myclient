package com.wjz.myclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jingzhi.wu on 2018/1/25.
 */
@RestController
public class RibbonController {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getOrder",method = RequestMethod.POST)
    public String getUser(@RequestParam(value="orderNo", required = true)String orderNo){
        //调用远程服务
        ResponseEntity<String> res = restTemplate.postForEntity("http://mySpringBootLearn1/order/queryOrderByNo", orderNo, String.class);
        System.out.println(res.toString());
        return res.toString();

    }
}
