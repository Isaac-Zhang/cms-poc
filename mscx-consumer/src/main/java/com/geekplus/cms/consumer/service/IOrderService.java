package com.geekplus.cms.consumer.service;

import com.geekplus.cms.consumer.dto.OrderDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 订单服务
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/29
 */
public interface IOrderService {

    /***
     * 创建订单
     *
     * @author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
     * @param orderDTO 创建订单传入的对象
     * @return OrderDTO 返回创建的用户信息
     * @throws {@link Exception} 错误信息
     */
    OrderDTO createOrder(OrderDTO orderDTO) throws Exception;

    /***
     * 查询所有订单
     *
     * @author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
     * @return java.util.List<com.geekplus.cms.producer.dto.entity.OrderEntity>
     * @throws
     */
    List<OrderDTO> findAllOrders();

    /***
     * 根据订单code查询
     *
     * @author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
     * @param orderCode 订单编码
     * @return com.geekplus.cms.producer.dto.entity.OrderEntity
     * @throws
     */
    OrderDTO findByOrderCode(String orderCode);
}
