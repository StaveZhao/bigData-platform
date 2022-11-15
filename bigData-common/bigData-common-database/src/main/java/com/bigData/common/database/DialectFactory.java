package com.bigData.common.database;

import com.bigData.common.database.constants.DbType;
import com.bigData.common.database.dialect.DialectRegistry;

/**
 * 方言工厂类
 *
 */
public class DialectFactory {

    private static final DialectRegistry DIALECT_REGISTRY = new DialectRegistry();

    public static DbDialect getDialect(DbType dbType) {
        return DIALECT_REGISTRY.getDialect(dbType);
    }
}
