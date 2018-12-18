package me.j360.swagger.boot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: min_xu
 * @date: 2018/1/18 上午11:41
 * 说明：
 */

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    private static String SECRET = "private secret";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor(SECRET))
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/guest", "/api/auth/login",
                        "/ws/**");
        super.addInterceptors(registry);
    }

}
