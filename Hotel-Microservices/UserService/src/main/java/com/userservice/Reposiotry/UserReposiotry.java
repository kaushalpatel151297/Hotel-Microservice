package com.userservice.Reposiotry;

import com.userservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiotry extends JpaRepository<User,String> {
}
