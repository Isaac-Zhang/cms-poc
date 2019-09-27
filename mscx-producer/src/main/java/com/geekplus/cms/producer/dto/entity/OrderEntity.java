package com.geekplus.cms.producer.dto.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 订单实体对象
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "poc_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Basic
    @Column(name = "order_code",nullable = false)
    private String orderCode;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Long createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Long updateTime;

    /**
     * 创建用户时所需的必填字段
     *
     * @param orderCode 订单编码
     */
    public OrderEntity(String orderCode) {
//        this.orderCode = orderCode;
//        this.createTime =(new Date()).getTime();
//        this.updateTime = this.createTime;
    }
}
