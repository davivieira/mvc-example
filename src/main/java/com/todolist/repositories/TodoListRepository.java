package com.todolist.repositories;

import com.todolist.collections.TodoList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoListRepository extends MongoRepository<TodoList, String> {
}
