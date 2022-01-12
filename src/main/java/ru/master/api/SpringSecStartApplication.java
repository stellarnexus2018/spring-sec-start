package ru.master.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.master.api.repository.MyUserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = MyUserRepository.class)
public class SpringSecStartApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringSecStartApplication.class, args);
  }
}