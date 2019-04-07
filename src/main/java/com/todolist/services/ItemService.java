package com.todolist.services;

import com.todolist.collections.Item;
import com.todolist.collections.enums.Message;
import com.todolist.collections.enums.Status;
import com.todolist.repositories.ItemRepository;
import com.todolist.services.helpers.Response;
import com.todolist.services.helpers.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final ResponseBuilder builder;


    @Autowired
    public ItemService(ItemRepository itemRepository, ResponseBuilder builder) {
        this.itemRepository = itemRepository;
        this.builder = builder;
    }

    public Response createItem(Item item) {
        setDefaultStartingValues(item);

        Item insertedItem = itemRepository.insert(item);

        return builder.getResponseContent(insertedItem,
                Message.ITEM_SAVED_SUCCESSFULLY.getText(),
                Message.ITEM_SAVE_FAILED.getText());
    }

    public Response deleteItem(String itemId) {
        try {
            itemRepository.deleteById(itemId);

            return builder.getResponseContent(true, Message.ITEM_DELETED_SUCCESSFULLY.getText());
        } catch (Exception e) {
            return builder.getResponseContent(false, Message.ITEMS_DELETION_FAILED.getText());
        }
    }

    public Response changeStatus(Item item) {
        Optional<Item> byId = itemRepository.findById(item.getId());

        Item dbItem = null;
        if (byId.isPresent()) {
            dbItem = byId.get();

            dbItem.setStatus(item.getStatus());
        }

        Item savedItem = itemRepository.save(dbItem);

        return builder.getResponseContent(savedItem,
                Message.ITEM_UPDATED_SUCCESSFULLY.getText(),
                Message.ITEM_UPDATE_FAILED.getText());
    }

    public Response deleteAll() {
        try {
            itemRepository.deleteAll();

            return builder.getResponseContent(true, Message.ITEMS_DELETED_SUCCESSFULLY.getText());
        } catch (Exception e) {
            return builder.getResponseContent(false, Message.ITEMS_DELETION_FAILED.getText());
        }
    }

    private void setDefaultStartingValues(Item item) {
        item.setCreationDate(LocalDateTime.now());
        item.setStatus(Status.OPENED);
    }
}
