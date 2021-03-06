# dbdoc
# 中文使用手册
dbdoc是一个基于poi-tl插件可以自动生成数据库文档的小程序。

## 立即开始
1. 首先把dbdoc\src\main\resources\template\dbdoc-template.docx文件（这是一个模板）复制到D盘根目录下，
2. 将代码在IDE中打开并启动springboot服务，然后在浏览器中输入：localhost:8080/build
3. 稍后你会在D盘根目录下找到一个XXXXXXX-数据库设计文档.docx的word文件，这就是自动生成的数据库文档了。

## 如何在我的项目中使用
1. 在你的项目pom.xml中引入poi-tl插件（这一步很关键），如下：
```<dependency><groupId>com.deepoove</groupId><artifactId>poi-tl</artifactId><version>1.12.0</version></dependency>```
2. 将dbdoc\src\main\java\com\gwl\dbdoc\service\TableService.java类拷贝至你的项目，或仅仅是复制代码到你的项目亦可
3. 开始使用，你可以写一个controller或是一个单元测试类来使用它

注：
1. 确认你的项目是否支持jdbc（常规的web项目已默认引入），如果没有，则需要在pom.xml中引入，如下：
```<dependency><groupId>org.springframework.boot</groupId><artifactId>spring-boot-starter-jdbc</artifactId></dependency>```
2. dbdoc-template.docx可以根据你的要求随意修改，但你需要知道poi-tl的标签语法，详情参考：http://deepoove.com/poi-tl/1.6.x/ 核心代码是dbdoc\src\main\java\com\gwl\dbdoc\service\TableService.java，调用在dbdoc\src\main\java\com\gwl\dbdoc\controller\TableController.java，你可以查看或调整以达到你的要求

## 项目优势
1. 极低的依赖和零侵入性，项目只需引入poi-tl插件即可使用
2. 极大的灵活性，稍加修改模板文件（dbdoc-template.docx）即可满足自己的要求

# User Manual
dbdoc is based poi-tl plugin,It can helpfull generate your database document more easy.

## Quick Start
1. First,Copy the dbdoc\src\main\resources\template\dbdoc-template.docx to your Disk D root directory.
2. Second,Clone this project to open it in your IDE,and input localhost:8080/build in your internet explorer and press enter key.
3. For a moment,you can see a 'XXXXXXX-数据库设计文档.docx' word file in your Disk D root directory,This is auto generate Database document.

## How to use in my project       
1. Import poi-tl plugin in your pom.xml:
```<dependency><groupId>com.deepoove</groupId><artifactId>poi-tl</artifactId><version>1.12.0</version></dependency>```      
2. Copy the dbdoc\src\main\java\com\gwl\dbdoc\service\TableService.java to your project.
3. Go start,you can write a controller or a unit test to use it now.

PS: You need make sure your project can support jdbc,import it if not have:
```<dependency><groupId>org.springframework.boot</groupId><artifactId>spring-boot-starter-jdbc</artifactId></dependency>```

PPS:  dbdoc-template.docx is a template word file,you can edit it anywhere,but you need to know poi-tl grammar,more detail: http://deepoove.com/poi-tl/1.6.x/ Core code is the dbdoc\src\main\java\com\gwl\dbdoc\service\TableService.java，dbdoc\src\main\java\com\gwl\dbdoc\controller\TableController.java is execute code.

## 效果图（Export Preview）
![image](/src/main/resources/export-preview/export-1.png)
![image](/src/main/resources/export-preview/export-1.png)
![image](/src/main/resources/export-preview/export-1.png)
