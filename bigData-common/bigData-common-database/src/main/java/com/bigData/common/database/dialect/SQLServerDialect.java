package com.bigData.common.database.dialect;

/**
 * SQLServer 数据库方言
 *
 */
public class SQLServerDialect extends SQLServer2008Dialect {

    @Override
    public String buildPaginationSql(String originalSql, long offset, long count) {
        StringBuilder sqlBuilder = new StringBuilder(originalSql);
        sqlBuilder.append(" OFFSET ").append(offset).append(" ROWS FETCH NEXT ").append(count).append(" ROWS ONLY ");
        return sqlBuilder.toString();
    }
}
