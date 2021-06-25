package org.goodStudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.config
 * @Date 2021/6/24 5:12 下午
 * @Version 1.0
 */
@Configuration
public class securityConfig implements WebSecurityConfigurer {
    @Override
    public void init(SecurityBuilder securityBuilder) throws Exception {

    }

    @Override
    public void configure(SecurityBuilder securityBuilder) throws Exception {

    }
}
