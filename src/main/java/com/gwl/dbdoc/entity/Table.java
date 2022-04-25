package com.gwl.dbdoc.entity;

import lombok.Data;

import java.util.List;

/**
 * 数据库表
 * @author GuanWL
 * @version 1.0
 */
@Data
public class Table {
    /** 数据表名称 */
    private String tableName;
    /** 数据表备注 */
    private String tableComment;
    /** 数据表列集合 */
    private List<Column> columns;
}
