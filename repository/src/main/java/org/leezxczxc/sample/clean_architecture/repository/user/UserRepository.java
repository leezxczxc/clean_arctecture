package org.leezxczxc.sample.clean_architecture.repository.user;

import java.util.List;
import org.leezxczxc.sample.clean_architecture.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by OGQ Corp. User: iseheon Created At: 2020/08/05 4:34 오후 Last Modified At: 2020/08/05
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findAll();
}
