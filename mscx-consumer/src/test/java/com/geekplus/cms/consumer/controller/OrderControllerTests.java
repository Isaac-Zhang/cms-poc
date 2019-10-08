package com.geekplus.cms.consumer.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.geekplus.cms.consumer.dto.OrderDTO;
import com.geekplus.cms.consumer.service.IOrderService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/***
 * 订单controller测试类
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OrderControllerTests {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new OrderController(new IOrderService() {
            @Override
            public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
                log.info("entering create order ...");
                return null;
            }

            @Override
            public List<OrderDTO> findAllOrders() {
                log.info("entering find all orders ...");
                return null;
            }

            @Override
            public OrderDTO findByOrderCode(String orderCode) {
                log.info("entering find order by code ...");
                return null;
            }
        })).build();
    }

    @Test
    public void testOrderController() throws Exception {
        // 测试OrderController
        RequestBuilder request;

        // 1、get查一下order列表，应该为空
        request = get("/order/");
        mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("")));

//        // 2、post提交一个 order
//        request = post("/order/create")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content("{\"id\":1,\"order_code\":\"code1\",\"create_time\":201111111}");
//        mvc.perform(request)
//            .andExpect(content().string(equalTo("success")));
//
//        // 4、put修改id为1的user
//        request = put("/users/1")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content("{\"name\":\"测试终极大师\",\"age\":30}");
//        mvc.perform(request)
//            .andExpect(content().string(equalTo("success")));
//
//        // 5、get一个id为1的user
//        request = get("/users/1");
//        mvc.perform(request)
//            .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
//
//        // 6、del删除id为1的user
//        request = delete("/users/1");
//        mvc.perform(request)
//            .andExpect(content().string(equalTo("success")));
    }
}
