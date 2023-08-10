package com.userservice.Service;

import com.userservice.Model.User;

import java.util.List;


public interface UserService {


     User createUser(User user);

     User getUser(String userId);

     List<User> getAllUser();
     User updateUser(User user,String userId);

     void deleteUser(String userId);

}
