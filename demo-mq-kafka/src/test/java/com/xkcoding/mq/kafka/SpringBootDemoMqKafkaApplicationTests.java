package com.xkcoding.mq.kafka;

import com.xkcoding.mq.kafka.constants.KafkaConsts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoMqKafkaApplicationTests {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 测试发送消息
     */
    @Test
    public void testSend() {
        kafkaTemplate.send(KafkaConsts.TOPIC_TEST, "hello,kafka...").addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            System.out.println("消息发送成功：" + topic + "-" + partition + "-" + offset);
        }, failure -> {
            String message = failure.getMessage();
            System.out.println("消息发送失败：" + message);
        });
    }

}

