package com.bigData.common.database;

import com.bigData.common.database.core.DbColumn;
import com.bigData.common.database.core.DbTable;
import org.springframework.jdbc.core.RowMapper;

/**
 * 表数据查询接口
 *
 */
public interface DbDialect {

    RowMapper<DbTable> tableMapper();

    RowMapper<DbColumn> columnMapper();

    /**
     * 获取指定表的所有列
     *
     * @param dbName
     * @param tableName
     * @return
     */
    String columns(String dbName, String tableName);

    /**
     * 获取数据库下的 所有表
     *
     * @param dbName
     * @return
     */
    String tables(String dbName);

    /**
     * 构建 分页 sql
     *
     * @param sql
     * @param offset
     * @param count
     * @return
     */
    String buildPaginationSql(String sql, long offset, long count);

    /**
     * 包装 count sql
     *
     * @param sql
     * @return
     */
    String count(String sql);

	/**
	 * oracl 读取long 类型会流关闭，是oracle的bug，需要特殊处理
	 * @return
	 */
	default RowMapper<DbColumn> columnLongMapper() {
		return null;
	};
}
