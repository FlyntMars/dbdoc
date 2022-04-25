package com.gwl.dbdoc.service;

import com.deepoove.poi.XWPFTemplate;
import com.gwl.dbdoc.entity.Column;
import com.gwl.dbdoc.entity.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主业务类
 * @author GuanWL
 * @version 1.0
 */
@Service
public class TableService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 根据数据库名获取所有数据表信息
     * @param tableSchema 数据库名
     * @return
     * @author GuanWL
     * @version 1.0
     */
    public List<Map<String,Object>> getTables(String tableSchema){
        String sql = "select table_name tableName,table_comment tableComment from information_schema.tables" +
                " where table_schema='"+tableSchema+"'";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 根据数据库名和数据表名获取数据表所有列名
     * @param tableSchema
     * @param tableName
     * @return
     * @author GuanWL
     * @version 1.0
     */
    public List<Map<String,Object>> getTableColumns(String tableSchema,String tableName){
        String sql = "select " +
                "COLUMN_NAME colName," +
                "DATA_TYPE dataType," +
                "NUMERIC_SCALE numScale," +
                "CHARACTER_MAXIMUM_LENGTH charMaxLength," +
                "(case IS_NULLABLE when 'YES' then 'Y' else 'N' end) isNullable," +
                "COLUMN_TYPE colType," +
                "(case COLUMN_KEY when 'PRI' then 'Y' else 'N' end) colKey," +
                "COLUMN_DEFAULT colDefault," +
                "COLUMN_COMMENT colComment" +
                " from information_schema.`COLUMNS` where TABLE_SCHEMA = '"+tableSchema+"' and TABLE_NAME = '"+tableName+
                "' order by TABLE_NAME,ORDINAL_POSITION";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 生成数据库设计Word文档
     * @param sysName 系统/项目名称
     * @param deptName 责任单位名称
     * @param author 文档作者
     * @param tableSchema 数据库名
     * @author GuanWL
     * @version 1.0
     */
    public void build(String sysName,String deptName,String author,String tableSchema) {
        // 获取所有表格的名称和schema
        List<Map<String, Object>> tableList = getTables(tableSchema);
        List<Table> tables = new ArrayList<>();
        String tableName = "";
        String tableComment = "";
        for (Map<String, Object> map : tableList) {
            // 获取表格信息
            tableName = String.valueOf(map.get("tableName"));
            tableComment = String.valueOf(map.get("tableComment"));
            List<Map<String, Object>> tbl = getTableColumns(tableSchema,tableName);
            // 遍历列并生成列集合
            List<Column> columns = new ArrayList<>();
            for (Map<String, Object> tt : tbl) {
                Column column = new Column();
                column.setColName(String.valueOf(tt.get("colName")));
                column.setDataType(String.valueOf(tt.get("dataType")));
                column.setNumScale(String.valueOf(tt.get("numScale")));
                column.setCharMaxLength(String.valueOf(tt.get("charMaxLength")));
                column.setIsNullable(String.valueOf(tt.get("isNullable")));
                column.setColType(String.valueOf(tt.get("colType")));
                column.setColKey(String.valueOf(tt.get("colKey")));
                column.setColDefault(String.valueOf(tt.get("colDefault")));
                column.setColComment(String.valueOf(tt.get("colComment")));
                columns.add(column);
            }
            // 新建表格对象并填充列和表格信息
            Table table = new Table();
            table.setTableName(tableName);
            table.setTableComment(tableComment);
            table.setColumns(columns);
            // 将新表格对象加入集合
            tables.add(table);
        }

        // 组装要渲染的word内容
        Map<String, Object> renderMap = new HashMap<>();
        renderMap.put("sysName",sysName);
        renderMap.put("deptName",deptName);
        renderMap.put("writeDate", LocalDate.now());
        renderMap.put("author",author);

        renderMap.put("schema",tableSchema);
//        renderMap.put("version","1.0.0");
        renderMap.put("tableList", tableList);
        renderMap.put("tableName", tableName);
        renderMap.put("tableComment", tableComment);
        renderMap.put("tables", tables);

        // 渲染word文件
        XWPFTemplate template = XWPFTemplate.compile("D:/dbdoc-template.docx").render(renderMap);
        // 输出到word文件
        try {
            template.writeAndClose(new FileOutputStream("D:/"+sysName+"-数据库设计文档.docx"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
