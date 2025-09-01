package org.example.expert.domain.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Slf4j
public class AdminIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "인증 실패");
            return false;
        }
        log.info("[AdminUser 접근] 요청 시각 = {}, 요청 URL = {}", LocalDateTime.now(), request.getRequestURI());
        return true;
    };

}
