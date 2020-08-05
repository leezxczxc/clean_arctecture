package org.leezxczxc.sample.clean_architecture.usecase.user;

import java.util.List;
import java.util.stream.Collectors;
import org.leezxczxc.sample.clean_architecture.domain.user.User;
import org.leezxczxc.sample.clean_architecture.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OGQ Corp. User: iseheon Created At: 2020/08/05 4:38 오후 Last Modified At: 2020/08/05
 */
@Service
public class UserFindUseCase {
  private final UserRepository userRepository;

  @Autowired
  public UserFindUseCase(
      final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<String> getAllUserString() {
    return userRepository.findAll().stream().map(User::toString).collect(Collectors.toList());
  }
}
