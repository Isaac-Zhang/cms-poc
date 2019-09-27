package com.geekplus.cms.producer.controller;

import com.alibaba.fastjson.JSON;
import com.geekplus.cms.producer.dto.OrderDTO;
import com.geekplus.cms.producer.service.IOrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/27
 */
@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private final IOrderService orderService;

    @PostMapping("/create")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        log.info("producer-service create order -> {}", JSON.toJSONString(orderDTO));
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/get/{code}")
    public OrderDTO getOrderByCode(@PathVariable String code) {
        log.info("producer-service get order by code -> {}", code);
        return orderService.findByOrderCode(code);
    }

    @GetMapping("/get")
    public List<OrderDTO> getOrders() {
        log.info("producer-service get all orders");
        List<OrderDTO> allOrders = orderService.findAllOrders();
        log.info("producer-service get all orders -> {}", JSON.toJSONString(allOrders));
        return allOrders;
    }
}
