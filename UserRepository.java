package com.example.TaskManagement.Repository;

import com.example.TaskManagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by email address, returning an Optional to handle absence gracefully
    Optional<User> findByEmail(String email);
    Optional<User> findByRole(String role);


    // Additional methods can be added here if needed
}
