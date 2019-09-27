package com.geekplus.cms.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/***
 * 创建订单请求对象
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private String orderCode;
    private Long orderId;
    private Long createTime;
    private Long updateTime;

    public boolean validate() {
        return !StringUtils.isEmpty(orderCode);
    }
}
