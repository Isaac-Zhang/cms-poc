package com.geekplus.cms.consumer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@ApiModel("订单实体DTO")
public class OrderDTO {

    @NotNull
    @ApiModelProperty(value = "订单编码", position = 1)
//    @Size(min = 2, max = 5)
//    @Max(100)
//    @Min(10)
//    @Email
    private String orderCode;

    @ApiModelProperty(value = "订单id", position = 2)
    private Long orderId;

    @ApiModelProperty(value = "订单创建时间", position = 3)
    private Long createTime;

    @ApiModelProperty(value = "订单修改时间", position = 4)
    private Long updateTime;
}
