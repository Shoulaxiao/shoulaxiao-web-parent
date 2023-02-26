package com.shoulaxiao.bookweb.dal.enums;

public enum DataSourceEnum {
    TEST("test"),
    BOOK_DB("bookdb");

    private final String name;

    DataSourceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
