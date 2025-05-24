package com.mg.store.config.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.mg.store.config.annotation.CurrentUser;
import com.mg.store.config.exception.UnauthorizedException;
import com.mg.store.entity.User;
import com.mg.store.service.UserService;

@Component
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(@NonNull MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class) &&
                parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(@Nullable MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
            @Nullable NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username == null) {
            throw new UnauthorizedException("No hay usuario autenticado.");
        }
        return userService.getByUserName(username);
    }
}