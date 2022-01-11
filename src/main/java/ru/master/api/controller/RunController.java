package ru.master.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RunController {
  @GetMapping("/")
  public ResponseEntity<?> home() {
    return ResponseEntity.ok("<h1>Welcome</h1>");
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