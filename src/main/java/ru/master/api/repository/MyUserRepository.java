package ru.master.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.master.api.entity.ActUser;

import java.util.List;
import java.util.Optional;

public interface MyUserRepository extends JpaRepository<ActUser, Long> {
  Optional<ActUser> findByUserName(String name);
  Optional<ActUser> findById(Long id);

  //@Override
  List<ActUser> findAll();
}