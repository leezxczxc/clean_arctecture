package org.leezxczxc.sample.clean_architecture.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by OGQ Corp. User: iseheon Created At: 2020/07/22 2:08 오후 Last Modified At: 2020/07/22
 */
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(final ServerHttpSecurity serverHttpSecurity) {
    return serverHttpSecurity
      .httpBasic().disable()
      .cors().disable()
      .csrf().disable()
      .formLogin().disable()
      .logout().disable()
      .headers().frameOptions().disable().and()
      .build()
      ;
  }

}
