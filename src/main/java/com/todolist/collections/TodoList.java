package com.todolist.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "todolist")
public class TodoList {

    @Id
    private String id;

    private List<Item> items;
    private String name;
    private double progress;

    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
