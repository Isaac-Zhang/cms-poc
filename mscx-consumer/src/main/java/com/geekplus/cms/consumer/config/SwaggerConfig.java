package com.geekplus.cms.consumer.config;

import com.google.common.base.Predicates;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 * 配置Swagger2
 *
 * @Company GeekPlus
 * @Project poc
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/8
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            //通过指定包名的方式，让 Swagger 只去某些包下面扫描。
            .apis(RequestHandlerSelectors.basePackage("com.geekplus.cms.consumer.controller"))
            //.apis(RequestHandlerSelectors.any())
            //通过筛选 API 的 url 来进行过滤。
            .paths(Predicates.or(PathSelectors.ant("/order/*"),PathSelectors.ant("/user/*")))
            //.paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "POC 集成 Swagger 实例",
            "网站：https://geekplus.com.cn，欢迎大家访问。",
            "API V1.0",
            "Terms of service",
            new Contact("dev", "https://geekplus.com.cn", "zhangpan@geekplus.com.cn"),
            "Apache", "http://www.apache.org/", Collections.emptyList());
    }
}
