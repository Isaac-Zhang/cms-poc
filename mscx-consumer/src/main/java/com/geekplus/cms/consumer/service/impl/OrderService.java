package com.geekplus.cms.consumer.service.impl;

import com.geekplus.cms.consumer.dto.OrderDTO;
import com.geekplus.cms.consumer.feign.IOrderFeignClient;
import com.geekplus.cms.consumer.service.IOrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/29
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService implements IOrderService {

    private final IOrderFeignClient orderFeignClient;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
        return this.orderFeignClient.createOrder(orderDTO);
    }

    @Override
    public List<OrderDTO> findAllOrders() {
        return this.orderFeignClient.getOrders();
    }

    @Override
    public OrderDTO findByOrderCode(String orderCode) {
        return this.orderFeignClient.getOrderByCode(orderCode);
    }
}
