package com.example.finalprojectback.service.imp;

import com.example.finalprojectback.entity.Task;
import com.example.finalprojectback.repository.TaskRepository;
import com.example.finalprojectback.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

    @Service
    public class TaskServiceImplementation implements TaskService {

        private final TaskRepository taskRepository;

        public TaskServiceImplementation(TaskRepository taskRepository) {
            this.taskRepository = taskRepository;
        }

        @Override
        public Task createTask(Task task) {
            return taskRepository.save(task);
        }

        @Override
        public List<Task> getAllTasks() {
            return taskRepository.findAll();
        }
        @Override
        public Task updateTask(Long id, Task task) {
            Task existingTask = taskRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Tâche non trouvée avec l'ID : " + id));

            existingTask.setTitle(task.getTitle());
            existingTask.setContent(task.getContent());
            existingTask.setUpdatedAt(LocalDateTime.now());

            return taskRepository.save(existingTask);
        }

        @Override
        public void deleteTask(Long id) {
            if (!taskRepository.existsById(id)) {
                throw new EntityNotFoundException("Tâche introuvable avec l’ID : " + id);
            }
            taskRepository.deleteById(id);
        }
    }


