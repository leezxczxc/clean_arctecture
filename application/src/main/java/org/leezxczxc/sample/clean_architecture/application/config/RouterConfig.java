package org.leezxczxc.sample.clean_architecture.application.config;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.leezxczxc.sample.clean_architecture.application.handler.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by OGQ Corp. User: iseheon Created At: 2020/07/22 2:09 오후 Last Modified At: 2020/07/22
 */
@Configuration
public class RouterConfig extends DelegatingWebFluxConfiguration {
  private Logger logger = LoggerFactory.getLogger(RouterConfig.class);

  @Bean
  public RouterFunction<ServerResponse> healthCheckRoute() {
    return RouterFunctions.route(GET("/ping"), (req) -> ServerResponse.ok().build());
  }

  @Bean
  public RouterFunction<ServerResponse> testRoute(TestHandler testHandler) {
    return RouterFunctions.route()
      .path("/test/v1", builder -> builder
        .nest(accept(MediaType.APPLICATION_JSON), nest_b -> nest_b
            .GET("", testHandler::getTest)
        ))
      .build();
  }

}
