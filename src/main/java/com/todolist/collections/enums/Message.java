package com.todolist.collections.enums;

public enum Message {
    ITEM_SAVED_SUCCESSFULLY("The item was saved successfully", 0),
    ITEM_SAVE_FAILED("The item was not saved", 10),
    ITEM_DELETED_SUCCESSFULLY("The item was deleted successfully", 1),
    ITEM_DELETION_FAILED("The item could not be deleted", 11),
    ITEM_UPDATED_SUCCESSFULLY("The item was updated successfully", 2),
    ITEM_UPDATE_FAILED("The item was not updated", 12),
    ITEMS_DELETED_SUCCESSFULLY("The items were deleted successfully", 3),
    ITEMS_DELETION_FAILED("The items could not be deleted", 13),

    LISTS_RETRIEVED_SUCCESSFULLY("Lists retrieved successfully", 4),
    LISTS_RETRIEVAL_FAILED("Could not retrieve lists", 14),
    LIST_SAVED_SUCCESSFULLY("List saved successfully", 5),
    LIST_NOT_SAVED("List could not be saved", 15),
    LIST_DELETED_SUCCESSFULLY("List deleted successfully", 6),
    LIST_DELETION_FAILED("List could not be deleted", 16);

    private final String text;
    private final int code;

    Message(String text, int code) {
        this.text = text;
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getText() {
        return this.text;
    }
}
