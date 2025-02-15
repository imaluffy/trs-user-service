package com.trs.trs_user_service.repo;

import com.trs.trs_user_service.model.User;
import com.trs.trs_user_service.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

    Optional<User> findByEmail(String email);
}
