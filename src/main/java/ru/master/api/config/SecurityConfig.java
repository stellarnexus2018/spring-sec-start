package ru.master.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // кастомизированные запросы на пользователя и роли
    auth.jdbcAuthentication()
        .dataSource(dataSource)
    .usersByUsernameQuery("select username, password, enabled from my_users where username = ?")
    .authoritiesByUsernameQuery("select username, authority from my_authorities where username = ?");

    // дефолтным скриптом
    /*auth.jdbcAuthentication()
        .dataSource(dataSource);*/

    // В БД H2 на дефолтной схеме
    /*auth.jdbcAuthentication()
        .dataSource(dataSource)
        .withDefaultSchema()
        .withUser(
            User.withUsername("igor")
                .password("pass")
                .roles("USER")
        )
        .withUser(
            User.withUsername("admin")
                .password("pass")
                .roles("ADMIN")
        );
*/


    // аутентификация в памяти
    /*auth.inMemoryAuthentication()
        .withUser("igor")
        .password("1111")
        .roles("USER")
        .and()
        .withUser("foo")
        .password("foo")
        .roles("ADMIN");*/
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("USER", "ADMIN")
        .antMatchers("/").permitAll()
        .and().formLogin();
  }
}