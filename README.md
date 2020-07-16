# ycy-mall

我的第一个web项目
SSM实现的一个商城系统
实现了一个商城应有的基本功能
实现通用mapper，可进行单表/多表联合查询
抽取BaseService基类，集成多条件查询和增删改，普通Service类继承此类只需写少量代码
手写代码和mybatis-generator生成的代码隔离
实现了一些mybatis-generator插件，数据全部采用软删除
拦截器+自定义注解实现用户权限鉴定
通过AOP切面+自定义参数注解，可以对方法参数进行校验
统一错误处理
