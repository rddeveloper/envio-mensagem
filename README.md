# Envio de Mensagens

Projeto criado utilizando o java e o apache kafka, cujo o objetivo é simular um producer de envio de mensagens.

# Tecnologias

Java 11\
Apache Kafka\
Jackson Databind

# Execução

## Docker-compose

Primeiramente execute o arquivo docker compose na sua máquina e garanta que o zookeeper e o kafka estejam sendo executados, dando o comando 

```docker
docker-compose up -d
```
o arquivo se encontra no diretorio /docker.

para verificar se as instâncias dos containers fora executados e estão levantadas, execute o comando

```docker
docker ps -a
```

## Criação do Tópico

Execute o comando para criação do tópico na sua máquina

```docker
docker-compose exec kafka kafka-topics.sh --bootstrap-server localhost:9092 --create --topic mensagem-envio
```

Confirme se o tópico foi criado com sucesso

```docker
docker-compose exec kafka kafka-topics.sh --bootstrap-server localhost:9092 --list
```
## JAVA
Com o kafka rodando na sua máquina, basta executar a classe com o método principal da classe ProcucerMensagem dentro do package service para que a instancia e as configurações do kafka sejam criadas e processadas, e o producer de mensagem seja executado.

```Java
public static void main(String args []) throws InterruptedException {
  Properties properties = new Properties();
          properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
          properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
          properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MensagemSerializer.class.getName());
  ....
}
```
o método esta com o while(true) assim sendo enviado n mensagems com um thread sleep de 200 e simulando o envio de mensagem em tempo real
```Java
  while (true) {
    Mensagem mensagem = gerarMensagem();
    ProducerRecord<String, Mensagem> producerRecord = new ProducerRecord<String, Mensagem>("mensagem-envio", mensagem);
    producer.send(producerRecord);
    Thread.sleep(200);
  }
```

## Dicas Extras
Para quem usa Linux e precisa de permissão de administrador, coloque o sudo no começo de cada comando referente ao docker ou docker-compose.\
Caso queira dar um stop nos containers rodando do docker na sua máquina, execute:

```docker
docker stop $(docker ps -aq)
```
