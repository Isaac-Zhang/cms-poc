package com.geekplus.cms.producer.service.impl;

import com.geekplus.cms.producer.dao.OrderRepository;
import com.geekplus.cms.producer.dto.OrderDTO;
import com.geekplus.cms.producer.dto.entity.OrderEntity;
import com.geekplus.cms.producer.service.IOrderService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 订单service
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/27
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService implements IOrderService {

    public static final String ERROR_PARAM = "参数错误！";
    private final OrderRepository orderRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {

        //校验过程
        if (!orderDTO.validate()) {
            log.error("Request params error: {}", orderDTO);
            throw new Exception(ERROR_PARAM);
        }
        //查重业务...

        //添加
        OrderEntity orderEntity = orderRepository.save(
            OrderEntity.builder()
                .orderCode(orderDTO.getOrderCode())
                .build());
        log.info("current order is : {}", orderEntity);
        return OrderDTO.builder()
            .orderId(orderEntity.getOrderId())
            .orderCode(orderEntity.getOrderCode())
            .createTime(orderEntity.getCreateTime())
            .updateTime(orderEntity.getUpdateTime())
            .build();
    }

    @Override
    public List<OrderDTO> findAllOrders() {
        List<OrderEntity> orderList = orderRepository.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(orderList)) {
            for (OrderEntity orderEntity : orderList) {
                orderDTOList.add(
                    OrderDTO.builder()
                        .orderId(orderEntity.getOrderId())
                        .orderCode(orderEntity.getOrderCode())
                        .createTime(orderEntity.getCreateTime())
                        .updateTime(orderEntity.getUpdateTime())
                        .build());
            }
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public OrderDTO findByOrderCode(String orderCode) {
        OrderEntity orderEntity = orderRepository.findByOrderCode(orderCode);
        OrderDTO result = OrderDTO.builder()
            .orderId(orderEntity.getOrderId())
            .orderCode(orderEntity.getOrderCode())
            .createTime(orderEntity.getCreateTime())
            .updateTime(orderEntity.getUpdateTime())
            .build();
        return result;
    }
}
