package com.example.TaskManagement.Repository;

import com.example.TaskManagement.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    // Additional methods if needed
    Optional<Team> findByName(String name);
}

