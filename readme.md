后端配置

修改src/main/resources/application.yaml文件
修改为自己的redis和mysqlIP和端口

在mysql中运行导入表数据
src/main/resources/db/hmdp.sql

运行项目
访问http://localhost:8081/shop-type/list
有数据说明启动正常

前端配置

前端项目文件在nginx-1.18.0
进入根目录cmd窗口输入start nginx.exe启动

访问http://localhost:8080


