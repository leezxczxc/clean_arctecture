package org.leezxczxc.sample.clean_architecture.application.handler;

import java.util.stream.Collectors;
import org.leezxczxc.sample.clean_architecture.usecase.user.UserFindUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by OGQ Corp. User: iseheon Created At: 2020/08/05 4:11 오후 Last Modified At: 2020/08/05
 */
@Service
public class TestHandler {

  private UserFindUseCase userFindUseCase;

  @Autowired
  public TestHandler(
      UserFindUseCase userFindUseCase) {
    this.userFindUseCase = userFindUseCase;
  }

  public Mono<ServerResponse> getTest(ServerRequest serverRequest) {
    return Mono.fromCallable(() -> userFindUseCase.getAllUserString().stream().collect(Collectors.joining("||")))
        .flatMap(str -> ServerResponse.ok().body(BodyInserters.fromValue(str)));
  }
}
