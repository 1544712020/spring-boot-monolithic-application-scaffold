# SpringBoot-Monolithic-Application-Scaffold

#### 介绍 :tw-1f4ce:  :tw-1f4ce:  :tw-1f4ce: 
此项目用于搭建一个通用的SpringBoot单体应用脚手架，脚手架集成了常用的框架以及中间件，还有一些常用的常用的工具类架包。

![实用技术思维导图](https://images.gitee.com/uploads/images/2020/0917/203344_5e71bd55_6533994.png "屏幕截图.png")
| 技术 :tw-1f51c:   |  说明  :tw-1f4dd: |
|-------|-------|
|  SpringBoot  |  容器+MVC框架 |
|  SpringSecurity | 认证和授权框架|
| MyBatis  |  ORM框架 |
|MyBatisPlus     |  MyBatis的增强工具  |
| MySQL  |  数据库 |
| Redis  |  分布式缓存 |
| RabbitMQ  | 消息队列  |
| Elasticsearch  |  搜索引擎 |
| JWT  | JWT登录支持  |
|  Lombok | 简化对象封装工具  |
|Druid   |  数据库连接池 |
| PageHelper	  | MyBatis物理分页插件  |
| Swagger-UI	 | 文档生成工具 |
| fastjson	 | JSON解析库 |

#### 多模块项目介绍 :

多模块项目概况图如下：
![输入图片说明](https://images.gitee.com/uploads/images/2020/1020/164909_48ac5f31_6533994.png "屏幕截图.png")
关于maven中的聚合和继承可以看这篇博客：[SpringBoot+Maven搭建多模块项目](https://blog.csdn.net/weixin_43894879/article/details/108829354)，通过这样的多模块构建以及优化让项目更易于管理维护。