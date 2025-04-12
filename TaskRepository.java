package com.example.TaskManagement.Repository;

import com.example.TaskManagement.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Find tasks by assigned user ID
    List<Task> findByAssignedUser_Id(Long userId);

    // Find tasks by team ID (assuming you have a 'team' relationship in your Task entity)
    List<Task> findByAssignedTeam_Id(Long teamId);

    // Find tasks by status (assuming you have a 'status' field in your Task entity)
    List<Task> findByStatus(String status);

    List<Task> findByUserId(Long userId);

    // You can add other custom query methods if needed. Example:
    // List<Task> findByDeadlineBefore(LocalDate date);
}
