# 📧 Microserviço - Email

SE DESEJAR EXECUTAR O PROJETO, SIGA AS INSTRUÇÕES ABAIXO. SE OCORRER ALGUM PROBLEMA, AVISE-ME E TE AJUDAREI A ULTRAPASSAR.  
📫 Meu e-mail de suporte: **jonascportugal30@gmail.com**

Este microserviço é responsável por **consumir mensagens da fila RabbitMQ** e simular o **envio de e-mails** com base nos dados recebidos do microserviço `user`.

---

## 🚀 Tecnologias utilizadas

- Java 17  
- Spring Boot  
- Spring Web → para definir os endpoints REST (se necessário para teste ou monitoramento)  
- Spring AMQP (RabbitMQ) → para comunicação com a fila e recebimento de mensagens  
- Spring Data JPA → para persistência dos logs de envio de e-mails (opcional)  
- Spring Validation → para validar os dados da mensagem recebida  
- PostgreSQL → SGBD  
- CloudAMQP → instância em nuvem do RabbitMQ  
- Maven → gerenciamento de dependências
- •	Spring MAIL→Para trabalhar com protocolo de envio de email

---

## 🧩 Funcionalidades

- Escuta da fila RabbitMQ (`email.queue`)
- Processamento assíncrono de mensagens
- Simulação de envio de e-mail com os dados recebidos
- Registro opcional de envio no banco de dados

---

## 🧪 Como executar

### ✅ Pré-requisitos

- Conta no CloudAMQP (ou uma instância RabbitMQ local)
- Java 17 ou superior
- Maven 3+
- PostgreSQL instalado e configurado

---

## ⚙️ Passos

```bash
# Clone este repositório

#Abra o projecto no seu IDE

Em aplication properties, adicione e configure estas variaveis:

server.port=8081 (aqui coloque a sua porta de preferência)
spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_DO_SEU_BANCO_DE_DADOS_DO_MICROSERVIÇO DE EMAIL
spring.datasource.username=postgres   (coloque o username do seu postgres)
spring.datasource.password=root       (coloque o a password do seu postgres)
spring.jpa.hibernate.ddl-auto=update  

spring.rabbitmq.addresses=URL_DO_RabbitMQ   (aqui adicione a url da fila do seu MabbitMq)
broker.queue.email.name=default.email

#FINALMENTE EXECUTE O PROJECTO.

#DEPOIS VÁ PARA O MICROSERVIÇO DO USER, EXECUTE O PROJECTO E FAÇA UM TESTE APARTIR DO POSTMAN E OU INSOMNIA

#Após excutar repare no terminal deste projecto e irá aparecer uma mensagem automaticamente, indicando que a comunicação foi bem sucedida



