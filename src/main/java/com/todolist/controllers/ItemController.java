package com.todolist.controllers;

import com.todolist.collections.Item;
import com.todolist.services.ItemService;
import com.todolist.services.helpers.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/create", produces = "application/json", method = RequestMethod.POST)
    public Response createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Response deleteItem(@RequestParam String itemId) {
        return itemService.deleteItem(itemId);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public Response deleteAll() {
        return itemService.deleteAll();
    }

    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public Response changeStatus(@RequestBody Item item) {
        return itemService.changeStatus(item);
    }
}
