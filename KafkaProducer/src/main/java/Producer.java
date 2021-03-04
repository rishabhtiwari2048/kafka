import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;

public class Producer {

    public void Sender() throws Exception{
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer producer = new KafkaProducer(properties);
        File file = new File("log.txt");
        Scanner sc = new Scanner(file);
        int key = 1;
        String value ;
        String topic = "cricket-lovers";

        while(sc.hasNextLine())
        {
            ProducerRecord record = new ProducerRecord(topic,key,sc.nextLine());
            producer.send(record);
            System.out.println("Record with key "+key+" has been sent");
            key++;
        }
    }
}
