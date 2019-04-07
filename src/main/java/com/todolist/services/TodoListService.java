package com.todolist.services;

import com.todolist.collections.TodoList;
import com.todolist.collections.enums.Message;
import com.todolist.repositories.TodoListRepository;
import com.todolist.services.helpers.Response;
import com.todolist.services.helpers.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;

    private final ResponseBuilder builder;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository, ResponseBuilder builder) {
        this.todoListRepository = todoListRepository;
        this.builder = builder;
    }


    public Response getLists() {
        List<TodoList> all = todoListRepository.findAll();
        return builder.getResponseContent(all,
                Message.LISTS_RETRIEVED_SUCCESSFULLY.getText(),
                Message.LISTS_RETRIEVAL_FAILED.getText());
    }

    public Response createList(TodoList todoList) {
        TodoList insertedList = todoListRepository.insert(todoList);
        return builder.getResponseContent(insertedList,
                Message.LIST_SAVED_SUCCESSFULLY.getText(),
                Message.LIST_NOT_SAVED.getText());
    }

    public Response deleteList(String listId) {
        try {
            todoListRepository.deleteById(listId);
            return builder.getResponseContent(true, Message.LIST_DELETED_SUCCESSFULLY.getText());
        } catch (Exception e) {
            return builder.getResponseContent(false, Message.LIST_DELETION_FAILED.getText());
        }
    }
}
