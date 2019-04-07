package com.todolist.collections.enums;

public enum Status {
    OPENED("Opened"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
