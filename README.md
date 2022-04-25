# dbdoc
一个基于poi-tl插件，可以自动生成数据库文档的小程序。
This project can helpfull generate your database document more easy.

### 1.如何使用
1.1首先把dbdoc\src\main\resources\template\dbdoc-template.docx文件（这是一个模板）复制到D盘根目录下，
1.2将代码在IDE中打开并启动springboot服务，然后在浏览器中输入：localhost:8080/build
1.3稍后你会在D盘根目录下找到一个XXXXXXX-数据库设计文档.docx的word文件，这就是自动生成的数据库文档了。

PS：dbdoc-template.docx可以根据你的要求随意修改，但你需要知道poi-tl的标签语法，详情参考：http://deepoove.com/poi-tl/1.6.x/
PPS：核心代码是dbdoc\src\main\java\com\gwl\dbdoc\service\TableService.java，调用在dbdoc\src\main\java\com\gwl\dbdoc\controller\TableController.java，你可以查看或调整以达到你的要求

### 如何在我的项目中使用
1 首先确认你的项目是否支持jdbc（常规的web项目已默认引入），如果没有，则需要在pom.xml中引入，如下：
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
2 在你的项目pom.xml中引入poi-tl插件（这一步很关键），如下：
<dependency>
            <groupId>com.deepoove</groupId>
            <artifactId>poi-tl</artifactId>
            <version>1.12.0</version>
        </dependency>
3 将dbdoc\src\main\java\com\gwl\dbdoc\service\TableService.java类拷贝至你的项目，或仅仅是复制代码到你的项目亦可
4 开始使用，你可以写一个controller或是一个单元测试类来使用它
