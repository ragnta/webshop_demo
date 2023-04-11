package com.szgomb.webshop.auth.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.szgomb.webshop.auth.service.AuthenticationService;

/**
 * 
 * Instantiate AuthenticationController
 * required an {@link AuthenticationService} implementation in the context
 * 
 * @author szgomb
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(AuthenticationControllerConfig.class)
public @interface EnableAuthenticationController {

}
