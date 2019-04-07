package com.todolist.collections;

import com.todolist.collections.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "item")
public class Item {
    @Id
    private String id;
    private LocalDate dueDate;
    private LocalDateTime creationDate;
    private String content;
    private Status status;
    private String todolistId;

    public String getId() {
        return id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTodolistId() {
        return todolistId;
    }

    public void setTodolistId(String todolistId) {
        this.todolistId = todolistId;
    }
}
