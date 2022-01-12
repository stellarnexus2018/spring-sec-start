package ru.master.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.master.api.entity.ActUser;
import ru.master.api.repository.MyUserRepository;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
  private final MyUserRepository myUserRepository;

  @Autowired
  public MyUserDetailService(MyUserRepository myUserRepository) {
    this.myUserRepository = myUserRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<ActUser> foundUser = myUserRepository.findByUserName(username);
    foundUser.orElseThrow(() -> new UsernameNotFoundException("Не найден пользователь: " + username));
    return foundUser.map(MyUserDetails::new).get();
  }
}