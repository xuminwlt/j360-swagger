package me.j360.swagger.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * 说明：
 */

@Profile(value = {"test", "dev"})
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket webApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .genericModelSubstitutes(DeferredResult.class)
                //.genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")       //prefix
                .select()
                    .paths(PathSelectors.regex("/boot/api/.*"))//过滤的接口
                    //.paths(PathSelectors.any())
                .build()
                .apiInfo(webApiInfo());
    }


    @Bean
    public Docket wsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ws")
                .genericModelSubstitutes(DeferredResult.class)
                //.genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                    .paths(PathSelectors.regex("/boot/ws/.*"))//过滤的接口
                    //.paths(PathSelectors.any())
                .build()
                .apiInfo(webApiInfo());
    }

    private ApiInfo webApiInfo() {
        Contact contact = new Contact("j360", "http://j360.me", "xumin.wlt@gmail.com");
        ApiInfo apiInfo = new ApiInfo("J360-BOOT-API接口",//大标题
                "",
                "1.0.0",
                "",
                contact,
                "",
                "",
                Collections.EMPTY_LIST
        );
        return apiInfo;
    }

}
