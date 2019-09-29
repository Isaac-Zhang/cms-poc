package com.geekplus.cms.consumer.controller;

import com.geekplus.cms.consumer.dto.OrderDTO;
import com.geekplus.cms.consumer.service.IOrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 消费端订单controller
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/29
 */
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;

    @PostMapping("/")
    private OrderDTO createOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/{code}")
    public OrderDTO findByCode(@PathVariable String code) {
        return orderService.findByOrderCode(code);
    }

    @GetMapping("/")
    public List<OrderDTO> findAll() {
        return orderService.findAllOrders();
    }
}
