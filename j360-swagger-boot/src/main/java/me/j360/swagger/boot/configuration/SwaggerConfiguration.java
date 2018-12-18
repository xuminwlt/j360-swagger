package me.j360.swagger.boot.configuration;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

/**
 * 说明：
 */

@Profile(value = {"test", "dev"})
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    //JWT Sample
    //String GLOBLE_TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ1c2VyIiwic3ViIjoiZjI3NmZmNDUtOTk4Ny00MDNmLWE1YzAtMmNhNDdiMTBhYzYyIiwiaXNzIjoiRm90b3BsYWNlIiwiZXhwIjoxNTQ0Nzc0NDc4LCJpYXQiOjE1NDQ2ODgwNzgsIm5vbmNlIjoxNTQ0Njg4MDc4NzM3LCJqdGkiOiJmNzFjNGYwYzViODc0MDgxYjIxMGJkZjU2ZTEyYTY5OCJ9.kaEbQ2T_2ghtJwYBY8DFZim9dTVHoYV9nNln_8WIpyw";

    /**
     * api授权接口
     * @return
     */
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
                .apiInfo(webApiInfo())
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }


    /**
     * 三方接口
     * @return
     */
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



    private List<ApiKey> securitySchemes() {
        return Lists.newArrayList(
                new ApiKey("Authorization", "Authorization", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return Lists.newArrayList((
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build()
        ));
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("Authorization", authorizationScopes));
    }

}
