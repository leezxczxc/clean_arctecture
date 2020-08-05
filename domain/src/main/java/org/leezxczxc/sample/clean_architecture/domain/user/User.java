package org.leezxczxc.sample.clean_architecture.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by OGQ Corp. User: iseheon Created At: 2020/08/05 4:29 오후 Last Modified At: 2020/08/05
 */

@Entity
@Table(name="user")
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  @Column(name = "username", length = 40)
  private String username;

  @Column(name = "nickname", length = 40)
  private String nickname;

  @Column(name = "email", length = 255)
  private String email;

  public User(){}
  public User(String username, String nickname, String email) {}

  public String getUsername() {
    return username;
  }

  public String getNickname() {
    return nickname;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", nickname='" + nickname + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
