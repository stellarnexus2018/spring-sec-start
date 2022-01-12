package ru.master.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "myusers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActUser {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
