# bigData
## 简介

该项目基于智数通项目简化，去除不必要的模块，仅保留项目开发中必备的模块。目的在于提取一个能供我们在实际项目开发中使用的微服务框架。系统采用 SpringCloud 微服务框架开发，模块划分明确，灵活可拓展，可应对高并发场景需求，兼顾本地，私有，公有云部署

## 主要技术

### 后段技术栈

- 开发框架：Spring Boot 2.3
- 微服务框架：Spring Cloud Hoxton.SR9 （配置详情：https://blog.csdn.net/qq_31851027/article/details/117117015）
- 安全框架：Spring Security + Spring OAuth 2.0
- 任务调度：Quartz 
- 持久层框架：MyBatis Plus
- 数据库连接池：Hikaricp
- 服务注册与发现: Spring Cloud Config
- 客户端负载均衡：Ribbon
- 熔断组件：Hystrix
- 网关组件：Spring Cloud Gateway
- 消息队列：Rabbitmq
- 缓存：Redis
- 日志管理：Logback
- 运行容器：Undertow
- 工作流: Flowable 6.5.0

### 前段技术栈

- JS框架：Vue、nodejs
- CSS框架：sass
- 组件库：ElementUI
- 打包构建工具：Webpack

## 功能简介

平台基础设置（关于系统监控部分还有功能待开发）

- 系统管理
  - 岗位管理：配置系统用户所属担任职务。
  - 部门管理：配置系统组织机构，树结构展现支持数据权限。
  - 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
  - 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
  - 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
  - 参数管理：对系统动态配置常用参数。
  - 字典管理：对系统中经常使用的一些较为固定的数据进行维护。
 - 系统监控
   - 登录日志：系统登录日志记录查询。
   - 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
 - 任务调度
   - 任务管理：在线（添加、修改、删除)任务调度。
   - 日志管理：任务调度执行结果日志。

## 模块介绍

```
bigData-cloud-pro -- 后端工程
├── bigData-ui-pro -- 前端工程[9528]
├── bigData-eureka -- 注册中心[8610]
├── bigData-config -- 配置中心[8611]
├── bigData-gateway -- Spring Cloud Gateway网关[8612]
├── bigData-auth -- 授权服务提供[8613]
├── bigData-common -- 系统公共模块
├    ├── bigData-common-core -- 公共工具类核心包
├    ├── bigData-common-database -- 数据库相关工具类包
├    ├── bigData-common-log -- 日志服务类包
├    ├── bigData-common-mybatis -- 数据源类包
├    ├── bigData-common-office -- word工具类包
├    ├── bigData-common-rabbitmq -- rabbitmq消息队列类包
├    ├── bigData-common-redis -- redis类包
├    ├── bigData-common-security -- 安全工具类包
├── bigData-modules -- 业务模块
├    ├── file-service-parent -- 文件管理模块[8811]
├    ├── quartz-service-parent -- 定时任务管理模块[8813]
├    ├── system-service-parent -- 平台基础设置管理模块[8810]
└── bigData-tools -- 图形化模块
├    ├── bigData-tool-monitor -- Spring Boot Admin监控 [8711]
```



## 项目部署

### IDEA启动

##### 1、创建数据库

数据库版本为 **mysql5.7** 及以上版本

依次创建一下数据库

```
bigData_cloud
bigData_cloud_quartz
```

字符集：**utf8mb4**
排序规则：**utf8mb4_general_ci**

数据库创建完毕，导入 db 文件夹下的 **sql** 脚本 即可完成数据库初始化（data_cloud_flowable 工作流会自动生成表）

##### 2、修改配置文件

修改 **bigData-config** 配置中心 **config** 文件夹下的配置文件，把 **redis**，**mysql** 和 **rabbitmq** 的配置信息改成自己的

##### 3、启动项目

依次启动bigData-eureka、bigData-config、bigData-gateway、bigData-auth、system-service、quartz-service下的服务

补充：

```
在启动system-service的时候有可能会报错
解决方法：
Build->compiler->User Local 
```

##### 4、启动前端

1. 启动前端，进入bigData-ui-pro目录下 先用npm install安装相关依赖
2. 进入bigData-ui-pro目录下，输入命令npm run serve 运行项目
3. 前端启动端口可修改vue.config.js中

### 打包部署

##### 1、创建数据库

数据库版本为 **mysql5.7** 及以上版本

依次创建一下数据库

```
bigData_cloud
bigData_cloud_quartz
```

字符集：**utf8mb4**
排序规则：**utf8mb4_general_ci**

数据库创建完毕，导入 db 文件夹下的 **sql** 脚本 即可完成数据库初始化（data_cloud_flowable 工作流会自动生成表）

##### 2、修改配置文件

修改 **bigData-config** 配置中心 **config** 文件夹下的配置文件，把 **redis**，**mysql** 和 **rabbitmq** 的配置信息改成自己的

##### 3、项目打包

代码倒入idea中，依赖加载完 

在项目根目录下执行 **mvn install**，**install**  完毕后可以获取到各个模块的 **jar** 包，上传到服务器的同一个文件夹，**依次执行**即可，部署脚本在 **sh** 目录下，内容如下（服务较多，一台服务器内存可能不够用，可考虑分开部署，自行修改脚本）：

```sh
#!/bin/sh
# eureka 注册中心
bigDataEureka=./bigData-eureka.jar
# config 配置中心
bigDataConfig=./bigData-config.jar
# gateway 网关
bigDataGateway=./bigData-gateway.jar
# oauth2 认证服务
bigDataAuth=./bigData-auth.jar
# 系统服务
systemService=./system-service.jar
# 任务调度服务
quartzService=./quartz-service.jar

case "$1" in
start)
    echo "--------bigDataEureka 开始启动--------------"
    nohup java -jar $bigDataEureka >/dev/null 2>&1 &
    bigDataEurekaPid=`ps -ef|grep $bigDataEureka |grep -v grep|awk '{print $2}'`
    until [ -n "$bigDataEurekaPid" ]
      do
       bigDataEurekaPid=`ps -ef|grep $bigDataEureka |grep -v grep|awk '{print $2}'`
      done
    echo "bigDataEurekaPid is $bigDataEurekaPid"
    echo "--------bigDataEureka 启动成功--------------"
    sleep 30

    echo "--------bigDataConfig 开始启动--------------"
    nohup java -jar $bigDataConfig >/dev/null 2>&1 &
    bigDataConfigPid=`ps -ef|grep $bigDataConfig |grep -v grep|awk '{print $2}'`
    until [ -n "$bigDataConfigPid" ]
      do
       bigDataConfigPid=`ps -ef|grep $bigDataConfig |grep -v grep|awk '{print $2}'`
      done
    echo "bigDataConfigPid is $bigDataConfigPid"
    echo "--------bigDataConfig 启动成功--------------"
    sleep 30

    echo "--------bigDataGateway 开始启动--------------"
    nohup java -jar $bigDataGateway >/dev/null 2>&1 &
    bigDataGatewayPid=`ps -ef|grep $bigDataGateway |grep -v grep|awk '{print $2}'`
    until [ -n "$bigDataConfigPid" ]
      do
       bigDataGatewayPid=`ps -ef|grep $bigDataGateway |grep -v grep|awk '{print $2}'`
      done
    echo "bigDataGatewayPid is $bigDataGatewayPid"
    echo "--------bigDataGateway 启动成功--------------"
    sleep 30

    echo "--------bigDataAuth 开始启动--------------"
    nohup java -jar $bigDataAuth >/dev/null 2>&1 &
    bigDataAuthPid=`ps -ef|grep $bigDataAuth |grep -v grep|awk '{print $2}'`
    until [ -n "$bigDataAuthPid" ]
      do
       bigDataAuthPid=`ps -ef|grep $bigDataAuth |grep -v grep|awk '{print $2}'`
      done
    echo "bigDataAuthPid is $bigDataAuthPid"
    echo "--------bigDataAuth 启动成功--------------"

    echo "--------systemService 开始启动--------------"
    nohup java -jar $systemService >/dev/null 2>&1 &
    systemServicePid=`ps -ef|grep $systemService |grep -v grep|awk '{print $2}'`
    until [ -n "$systemServicePid" ]
      do
       systemServicePid=`ps -ef|grep $systemService |grep -v grep|awk '{print $2}'`
      done
    echo "systemServicePid is $systemServicePid"
    echo "--------systemService 启动成功--------------"

    echo "--------quartzService 开始启动--------------"
    nohup java -jar $quartzService >/dev/null 2>&1 &
    quartzServicePid=`ps -ef|grep $quartzService |grep -v grep|awk '{print $2}'`
    until [ -n "$quartzServicePid" ]
      do
       quartzServicePid=`ps -ef|grep $quartzService |grep -v grep|awk '{print $2}'`
      done
    echo "quartzServicePid is $quartzServicePid"
    echo "--------quartzService 启动成功--------------"
;;
stop)
    P_ID=`ps -ef|grep $bigDataEureka |grep -v grep|awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
      echo "===bigDataEureka process not exists or stop success"
    else
      kill -9 $P_ID
      echo "bigDataEureka killed success"
    fi

    P_ID=`ps -ef|grep $bigDataConfig |grep -v grep|awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
      echo "===bigDataConfig process not exists or stop success"
    else
      kill -9 $P_ID
      echo "bigDataConfig killed success"
    fi

    P_ID=`ps -ef|grep $bigDataGateway |grep -v grep|awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
      echo "===bigDataGateway process not exists or stop success"
    else
      kill -9 $P_ID
      echo "bigDataGateway killed success"
    fi

    P_ID=`ps -ef|grep $bigDataAuth |grep -v grep|awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
      echo "===bigDataAuth process not exists or stop success"
    else
      kill -9 $P_ID
      echo "bigDataAuth killed success"
    fi

    P_ID=`ps -ef|grep $systemService |grep -v grep|awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
      echo "===systemService process not exists or stop success"
    else
      kill -9 $P_ID
      echo "systemService killed success"
    fi

    P_ID=`ps -ef|grep $quartzService |grep -v grep|awk '{print $2}'`
    if [ "$P_ID" == "" ]; then
      echo "===quartzService process not exists or stop success"
    else
      kill -9 $P_ID
      echo "quartzService killed success"
    fi
;;
restart)
    $0 stop
    sleep 10
    $0 start
    echo "===restart success==="
;;
esac
exit 0
```

启动：datx-cloud-pro.sh start 

关闭：datx-cloud-pro.sh stop

重启：datx-cloud-pro.sh restart

用户名：admin

密码：123456
