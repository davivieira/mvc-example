package com.todolist.repositories;

import com.todolist.collections.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
