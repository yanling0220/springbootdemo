package com.aceyan.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * redis session config
 *
 *
 *如果需要添加失效时间可以使用以下的写法：
 *@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 60) //1分钟失效
 *相关配置修改
 *在application.properties修改redis配置信息（请自行安装redis），请根据实际修改。如：
 *spring.redis.host=127.0.0.1
 *所有实体类实现Serializable接口
 *public classSysResourceimplementsSerializable
 *查看效果
 *这时候登录系统在不同的app之间跳转的时候，session都是一致了，redis上可以看到：
 *总结
 *使用这些代码之后 ，无论你使用nginx或者apache，都无须在关心多个app之间的session一致的问题了。
 *注意事项
 *（1）redis版本号需要是2.8以上否则会抛异常：ERR Unsupported CONFIG parameter: notify-keyspace-events；
 *（2）RedisSessionConfig需要放在App.java启动类可以扫描的位置；
 *
 *
 * @author yanling
 * @time 2018-02-06-10:13
 */
@Configuration
@EnableRedisHttpSession()
public class RedisSessionConfig {
}
