package com.geekplus.cms.producer.dao;

import com.geekplus.cms.producer.dto.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * 订单数据表操作接口
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/27
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    /***
     * 根据订单编码查询订单
     *
     * @author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
     * @param orderCode
     * @return com.geekplus.cms.producer.dto.entity.OrderEntity
     * @throws
     */
    OrderEntity findByOrderCode(String orderCode);
}
