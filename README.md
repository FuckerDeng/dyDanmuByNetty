# <center>斗鱼弹幕程序用netty框架实现
![img](https://github.com/FuckerDeng/dyDanmuByNetty/blob/master/imgs/gift.gif)
### 程序运行
```
1、下载可执行jar包：
-下载发布版本中的jar包：dyDanmuByNetty-*.0-SNAPSHOT.jar

2、新建配置文件目录：
-在jar包的同级目录新建config目录，并把项目config目录中的
config.properties、mysql.sql、mybatis.xml文件拷贝到新建的目录

3、配置房间号：
-在config.properties中，可以根据自己的需要改动要爬取的房间号，房间号一般就为
直播连接后面的数字（有些需要在网页源代码中查找，我的另一个程序是专门爬取斗鱼
每个频道热度前20名的，可以参考那个程序）

4、数据库建表：
-在自己的数据库（mysql）中，创建数据库douyu，然后执行项目config目录下的sql文件中的最后一个表

5、给程序配置数据库
-配置表mybatis.xml中username和password配置成自己数据库的
-如果是远程数据库，可以根据需要更改数据库的url

6、window机器上的话，直接打开控制台，输入
    java -jar dyDanmuByNetty-1.0-SNAPSHOT.jar
即可

7、linux下的话，如果要后台运行，可以执行以下命令：
    nohup java -jar dyDanmuByNetty-1.0-SNAPSHOT.jar 2>&1 &
如果想结束，则先执行 ps -ef | grep java  找到刚才的java程序进程号，直接执行命令 kill 进程号 结束程序

```

----
#### =本程序依赖斗鱼的第3方API，此程序仅用于学习，禁止商业用途，禁止恶意爬虫增加斗鱼服务器压力
#### =程序产生的日志都放在log目录下，每小时分一个日志文件
#### =目前程序只能单个房间进行爬取，后续会增加多个房间同时爬取的功能
#### =大主播的礼品信息非常多，注意准备大的硬盘存数据，经常清理日志
### 如果程序有报错或者有更好的功能方案，欢迎与我联系，844537819@qq.com
