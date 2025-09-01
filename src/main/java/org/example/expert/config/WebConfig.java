package org.example.expert.config;

import org.example.expert.domain.intercepter.AdminIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthUserArgumentResolver authUserArgumentResolver;

    public WebConfig(AuthUserArgumentResolver authUserArgumentResolver) {
        this.authUserArgumentResolver = authUserArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(authUserArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AdminIntercepter())
                .addPathPatterns("/admin/**"); // admin 접근시
    }

}
