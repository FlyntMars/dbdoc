package com.gwl.dbdoc.entity;

import lombok.Data;

/**
 * 数据表列
 * @author GuanWL
 * @version 1.0
 */
@Data
public class Column {
    /** 列名称 */
    private String colName;
    /** 数据类型 */
    private String dataType;
    /** 数字精度 */
    private String numScale;
    /** 字符长度 */
    private String charMaxLength;
    /** 是否允许为空 */
    private String isNullable;
    /** 列类型 */
    private String colType;
    /** 是否主键 */
    private String colKey;
    /** 默认值 */
    private String colDefault;
    /** 列注释 */
    private String colComment;

}
