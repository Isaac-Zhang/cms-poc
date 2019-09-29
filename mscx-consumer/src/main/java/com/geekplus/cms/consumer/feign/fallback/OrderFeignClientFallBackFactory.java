package com.geekplus.cms.consumer.feign.fallback;

import com.geekplus.cms.consumer.dto.OrderDTO;
import com.geekplus.cms.consumer.feign.IOrderFeignClient;
import feign.hystrix.FallbackFactory;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/29
 */
@Slf4j
@Component
public class OrderFeignClientFallBackFactory implements
    FallbackFactory<IOrderFeignClient> {

    @Override
    public IOrderFeignClient create(Throwable cause) {
        return new IOrderFeignClient() {
            @Override
            public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
                log.warn("远程调用创建订单被限流/降级，{}", cause);
                return OrderDTO.builder()
                    .orderCode("create 被限流啦！！！")
                    .build();
            }

            @Override
            public OrderDTO getOrderByCode(String code) {
                log.warn("远程调用findByCode被限流/降级，{}", cause);
                return OrderDTO.builder()
                    .orderCode("findByCode 被限流啦！！！")
                    .build();
            }

            @Override
            public List<OrderDTO> getOrders() {
                log.warn("远程调用findAll被限流/降级，{}", cause);
                return Collections.singletonList(
                    OrderDTO.builder()
                        .orderCode("findAll 被限流啦！！！")
                        .build()
                );
            }
        };
    }
}
