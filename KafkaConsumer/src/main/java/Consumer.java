import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {

    public void Receiver(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id","LogConsumers");

        KafkaConsumer<Integer,String> consumer = new KafkaConsumer<Integer,String>(properties);

        consumer.subscribe(Arrays.asList("cricket-lovers"));

        while (true)
        {
            ConsumerRecords<Integer, String> records = consumer.poll(100);

            for(ConsumerRecord<Integer, String> record : records)
            {
                System.out.println("key "+ record.key()+" "+"value "+record.value());
            }

        }

    }
}
