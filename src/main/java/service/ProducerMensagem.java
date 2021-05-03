package service;

import model.Mensagem;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import serializer.MensagemSerializer;

import java.util.Properties;
import java.util.UUID;

public class ProducerMensagem {

    private static long operacaoMensagem = 0;

    public static void main(String args []) throws InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MensagemSerializer.class.getName());

        try(KafkaProducer<String, Mensagem> producer = new KafkaProducer<String, Mensagem>(properties)){
          while (true) {
              Mensagem mensagem = gerarMensagem();
              ProducerRecord<String, Mensagem> producerRecord = new ProducerRecord<String, Mensagem>("mensagem-envio", mensagem);
              producer.send(producerRecord);
              Thread.sleep(200);
          }
//            Mensagem mensagem = gerarMensagem();
//            ProducerRecord<String, Mensagem> producerRecord = new ProducerRecord<String, Mensagem>("mensagem-envio", mensagem);
//            producer.send(producerRecord);
        }


    }

    private static Mensagem gerarMensagem() {
        return new Mensagem(UUID.randomUUID(),
                "Mensagem " + operacaoMensagem++ + " enviada pelo producer",
                "Mensagem Kafka Producer",
                "Roberto Danilo");
    }

}
