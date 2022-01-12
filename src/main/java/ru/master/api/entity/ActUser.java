package ru.master.api.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "my_users")
@Data
public class ActUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "user_name")
  private String userName;
  @Column(name = "password")
  private String password;
  @Column(name = "roles")
  private String roles;
  @Column(name = "active")
  private Boolean active;
}