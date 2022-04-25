package com.gwl.dbdoc.controller;

import com.gwl.dbdoc.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主控制器
 * @author GuanWL
 * @version 1.0
 */
@Controller
public class TableController {
    @Autowired
    private TableService tableService;

    /**
     * 浏览器调用：localhost:8080/build来执行
     * @return
     * @author GuanWL
     * @version 1.0
     */
    @RequestMapping("build")
    public String build(){
        tableService.build("XXXXXXXXXXXXXX系统","XXXX科技有限公司","GuanWL","test");
        return "success";
    }

}
