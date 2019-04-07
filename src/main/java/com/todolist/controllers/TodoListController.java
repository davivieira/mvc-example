package com.todolist.controllers;

import com.todolist.collections.TodoList;
import com.todolist.services.TodoListService;
import com.todolist.services.helpers.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @RequestMapping(value = "/fetch", produces = "application/json", method = RequestMethod.GET)
    public Response getLists() {
        return todoListService.getLists();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Response createList(@RequestBody TodoList todoList) {
        return todoListService.createList(todoList);
    }

    @RequestMapping(value = "/delete/{listId}", method = RequestMethod.DELETE)
    public Response deleteList(@PathVariable String listId) {
        return todoListService.deleteList(listId);
    }
}
