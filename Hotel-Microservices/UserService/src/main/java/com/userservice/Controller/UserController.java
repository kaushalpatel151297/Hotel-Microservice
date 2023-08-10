package com.userservice.Controller;

import com.userservice.Model.ApiResponse;
import com.userservice.Model.User;
import com.userservice.Service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    public  UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/")
    public ResponseEntity<User> CreateUser(@RequestBody User user)
    {
        User user1 = this.userService.createUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUsebyID(@PathVariable("userId") String userId)
    {
        User user = this.userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> Updateuser(@RequestBody User user,@PathVariable("userId") String userId)
    {
        User user1 = this.userService.updateUser(user,userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getallUser()
    {
        List<User> allUser = this.userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(allUser);
    }

}
