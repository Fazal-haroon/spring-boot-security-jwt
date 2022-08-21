package com.example.springsecurityjwt;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    @Autowired
    private UserRepository userRepository;
    //application start-up first these list of object will insert
    @PostConstruct
    public void initUsers(){
        List<User> users = Stream.of(
                new User(21, "fazal", "password","fazal@gamil.com"),
                new User(22, "haroon", "password2", "haroon@gmail.com"),
                new User(23, "user", "password3", "user@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

}
