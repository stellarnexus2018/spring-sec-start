package ru.master.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RunController {
  @GetMapping("/")
  public ResponseEntity<?> runOne() {
    return ResponseEntity.ok("<h1>Welcome</h1>");
  }
}