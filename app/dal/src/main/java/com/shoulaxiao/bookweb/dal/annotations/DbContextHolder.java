package com.shoulaxiao.bookweb.dal.annotations;

import com.shoulaxiao.bookweb.dal.enums.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbContextHolder {

    private static final ThreadLocal<DataSourceEnum> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void set(DataSourceEnum dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static DataSourceEnum get() {
        return CONTEXT_HOLDER.get();
    }

    public static void clear() {
        CONTEXT_HOLDER.remove();
    }
}
