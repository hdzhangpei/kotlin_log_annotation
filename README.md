# 基于kotlin+springAop+aspectJ的注解日志,并为每一个请求附带一个唯一的KEY,用于快速定位日志

1.test包中有demo,运行可监控运行机制.

2.提供了生成统一格式的LogFormatUtils工具类,模板可自行修改.

3.提供了注解LogPrint.方法入口处type一定选择LogTypeEnum.ENTRANCE,不然多个请求对应的key不会更新.

4.提供了查询当前线程唯一key的方法.用于标记自己系统的业务日志.

5.新手一枚,欢迎提出宝贵意见.
