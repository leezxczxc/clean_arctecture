package org.leezxczxc.sample.clean_architecture.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by OGQ Corp. User: iseheon Created At: 2020/08/05 4:04 오후 Last Modified At: 2020/08/05
 */
@SpringBootApplication(scanBasePackages = {"org.leezxczxc.sample.clean_architecture"})
public class Application {
  public static void main(String [] args) {
    SpringApplication.run(Application.class, args);
  }
}
