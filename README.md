# SpringBoot-Monolithic-Application-Scaffold

#### 介绍 :tw-1f4ce:  :tw-1f4ce:  :tw-1f4ce: 
此项目用于搭建一个通用的SpringBoot单体应用脚手架，脚手架集成了常用的框架以及中间件，还有一些常用的常用的工具类架包。完成以后不用再重复的搭建SpringBoot单体应用的基础架构，可以大大提升开发效率。  :tw-1f4aa:  :tw-1f4aa:  :tw-1f4aa: 

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

目前已完成大部分技术的相关整合，除了消息队列(RabbitMQ)以及搜索引擎(Elasticsearch)。其余的技术都完成了最基本的配置和整合，因为并没有比较复杂的业务背景所以对于向我这样入门 :tw-1f605:  :tw-1f605: springboot的新手来说是比较容易的。以后随着自己技术不断提升 :tw-1f680:  :tw-1f680: ，会不断更新这个仓库，之后会将单体应用变成多模块应用，以符合企业级开发模式 :tw-1f4af:  :tw-1f4af: 。