package com.qiux.tspringboot.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author qiux
 * @Date 2022/3/10
 * @since
 */
@Configuration
public class IRedisComponent {


    @Autowired
    private RedisProductMessageListener redisProductMessageListener;

    @Autowired
    private RedisOrderMessageListener redisOrderMessageListener;

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) throws JsonProcessingException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashValueSerializer(jsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        MessageListenerAdapter messageListener = new MessageListenerAdapter(redisProductMessageListener);
        messageListener.afterPropertiesSet();
        listenerContainer.addMessageListener(messageListener, new ChannelTopic("product"));

        MessageListenerAdapter messageOrderListener = new MessageListenerAdapter(redisOrderMessageListener);
        messageOrderListener.afterPropertiesSet();
        listenerContainer.addMessageListener(messageOrderListener, new ChannelTopic("order"));
        return listenerContainer;
    }


}
