package cn.coding.com.exchangerates.config;

import cn.coding.com.exchangerates.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/login",
                "/api/**",
                "/css/**",
                "/images/**",
                "/javascript/**",
                "/contact/**",
                "/service/**",
//                "/customer/**",
//                "/exchange-rates/**",
                "/home/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/").setViewName("forward:/customer/list");
       registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
