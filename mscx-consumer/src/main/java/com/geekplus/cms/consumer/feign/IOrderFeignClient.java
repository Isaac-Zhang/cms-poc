package com.geekplus.cms.consumer.feign;

import com.geekplus.cms.consumer.dto.OrderDTO;
import com.geekplus.cms.consumer.feign.fallback.OrderFeignClientFallBackFactory;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
    name = "mscx-producer",
    fallbackFactory = OrderFeignClientFallBackFactory.class
)
@RequestMapping("/order-service/order")

/*
 * 创建请求producer-service 的feignClient
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/29
 */
public interface IOrderFeignClient {

    @PostMapping("/create")
    OrderDTO createOrder(@RequestBody OrderDTO orderDTO) throws Exception;

    @GetMapping("/get/{code}")
    OrderDTO getOrderByCode(@PathVariable String code);

    @GetMapping("/get")
    List<OrderDTO> getOrders();
}
