package serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Mensagem;
import org.apache.kafka.common.serialization.Serializer;

public class MensagemSerializer implements Serializer<Mensagem> {
    @Override
    public byte[] serialize(String s, Mensagem mensagem) {
        try {
            return new ObjectMapper().writeValueAsBytes(mensagem);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
