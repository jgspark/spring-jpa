package com.example.springjpa.web;

import com.example.springjpa.domain.user.User;
import com.example.springjpa.service.user.UserService;
import com.example.springjpa.web.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by pnw1517@gmail.com on 2020.07.22
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api/app/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<User> showByUserList(){
       return service.getByUserList();
    }

    @PostMapping("")
    public void saveByUserInfo(@RequestBody UserDto dto){
        service.createByUser(dto);
    }

    @PutMapping("/{seq}")
    public void modifyFromUserInfo(@PathVariable long seq , @RequestBody UserDto dto){
        service.updateByUser(seq , dto);
    }

    @DeleteMapping("/{seq}")
    public void removeFromUser(@PathVariable long seq){
       service.removeByUser(seq);
    }

}
