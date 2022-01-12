package ru.master.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.master.api.entity.ActUser;
import ru.master.api.repository.MyUserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class RunController {
  @Autowired
  private MyUserRepository myUserRepository;

  @GetMapping("/")
  public ResponseEntity<?> home() {
    //Optional<ActUser> byId = myUserRepository.findById(1L);
    List<ActUser> allData = myUserRepository.findAll();



    //return ResponseEntity.ok(byId.orElse(new ActUser()));
    return ResponseEntity.ok(allData);
  }

  @GetMapping("/user")
  public ResponseEntity<?> user() {
    return ResponseEntity.ok("<h1>Welcome User</h1>");
  }

  @GetMapping("/admin")
  public ResponseEntity<?> admin() {
    return ResponseEntity.ok("<h1>Welcome Admin</h1>");
  }
}