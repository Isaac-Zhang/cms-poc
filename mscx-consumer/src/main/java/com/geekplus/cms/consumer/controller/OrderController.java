package com.geekplus.cms.consumer.controller;

import com.geekplus.cms.consumer.dto.OrderDTO;
import com.geekplus.cms.consumer.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

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
@Api(tags = "订单相关接口", description = "提供订单相关的 Rest API")
public class OrderController {

    private final IOrderService orderService;

    @PostMapping("/")
    @ApiOperation(value = "创建订单",notes = "根据OrderDTO对象创建订单")
    private OrderDTO createOrder(@Valid @RequestBody OrderDTO orderDTO) throws Exception {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/{code}")
    @ApiOperation("根据code查询订单")
    public OrderDTO findByCode(@PathVariable String code) {
        return orderService.findByOrderCode(code);
    }

    @GetMapping("/")
    @ApiOperation("查询全部订单")
    public List<OrderDTO> findAll() {
        return orderService.findAllOrders();
    }


    @DeleteMapping("/{order_id}")
    @ApiOperation("根据id删除订单")
//    @ApiIgnore
    public void deleteOrder(@PathVariable Integer order_id) {
        log.info("delete order where order_id = {}", order_id);
    }

    @PutMapping("/{order_id}")
    @ApiOperation("根据id更新订单")
    public void updateOrder(@PathVariable Integer order_id) {
        log.info("update order where order_id = {}", order_id);
    }
}
