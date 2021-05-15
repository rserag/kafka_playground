package com.github.rserag.kafka.test1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerWithCallback {
    public static void main(String[] args) {
        // create Producer properties
        String bootstrapServers = "127.0.0.1:9092";
        String topic = "first_topic";


        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // create prod rec
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello world");

        // send data
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {

            }
        });

        // flush and close
        producer.flush();
        producer.close();
    }
}
