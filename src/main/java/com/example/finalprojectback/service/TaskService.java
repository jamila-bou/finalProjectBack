package com.example.finalprojectback.service;



import com.example.finalprojectback.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    void deleteTask(Long id);
    Task updateTask(Long id, Task task);
}

