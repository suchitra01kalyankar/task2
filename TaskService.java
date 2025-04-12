package com.example.TaskManagement.Service;

import com.example.TaskManagement.Entities.Task;
import com.example.TaskManagement.Exceptions.InvalidInputException;
import com.example.TaskManagement.Exceptions.ResourceNotFoundException;
import com.example.TaskManagement.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Read operation - get Task by ID
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
    }

    // Create operation - create new Task
    public Task createTask(Task task, Long userId, Long teamId) {
        if (task == null || task.getTitle() == null || task.getDeadline() == null) {
            throw new InvalidInputException("Task details are incomplete.");
        }

        // Optionally, associate user and team to the task here
        // task.setUserId(userId);
        // task.setTeamId(teamId);

        return taskRepository.save(task);
    }

    // Update operation - update an existing Task
    public Task updateTask(Long taskId, Task taskDetails) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        // Update task fields
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDeadline(taskDetails.getDeadline());
        task.setAssignedUser(taskDetails.getAssignedUser());

        // Optionally, you can update other fields here

        return taskRepository.save(task);
    }

    // Delete operation - delete a Task by ID
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        taskRepository.delete(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public List<Task> getTasksByUserId(Long userId) {
        List<Task> tasks = taskRepository.findByUserId(userId);  // Assuming you have a query method in your repository
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found for user with id: " + userId);
        }
        return tasks;
    }

    // Update task status
    public Task updateTaskStatus(Long taskId, String status) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        task.setStatus(status); // Assuming you have a status field in your Task entity
        return taskRepository.save(task);
    }

    // Additional methods can go here, for example, to find tasks by a specific filter like userId or teamId
}



