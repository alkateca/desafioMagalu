# desafioMagalu
Agendador de Comunicações:

API REST desenvolvida com base no desafio técnico [(enunciado)](https://github.com/alkateca/desafioMagalu/blob/main/enunciado.md) da vaga de desenvolvedor backend da Magalu, focada no envio de comunicações para clientes. 

O sistema permite agendar, consultar e cancelar o envio de mensagens por diferentes canais como E-mail, SMS, Push e WhatsApp.

✨ Funcionalidades

Agendamento de novas comunicações com data e hora futuras.

Consulta do status de um agendamento específico pelo seu ID.

Cancelamento de um agendamento existente.

🚀 Tecnologias Utilizadas

Java 17

Spring Boot

Spring Data JPA / Hibernate

Maven

Docker & Docker Compose

MySQL

🛠️ Como Executar o Projeto

Pré-requisitos
Java JDK 24 ou superior.

Apache Maven 3.8 ou superior.

Docker e Docker Compose instalados e em execução.

# Configuração e Execução

O projeto é configurado para se conectar a uma instância do MySQL gerenciada pelo Docker Compose.

Clone o repositório:

git clone [https://github.com/alkateca/desafioMagalu.git](https://github.com/alkateca/desafioMagalu.git)

cd desafioMagalu

cd docker

docker-compose up -d

Verifique a configuração da aplicação:

O arquivo src/main/resources/application.properties já deve estar configurado para se conectar ao contêiner Docker. As credenciais (username, password, url) devem corresponder às definidas no arquivo docker-compose.yml.

Execute a aplicação Spring Boot:

mvn spring-boot:run

Pronto! A API estará disponível em http://localhost:8080.


# API Endpoints
1. Agendar Comunicação
POST /api/agendamentos

Descrição: Cria e agenda uma nova comunicação.

Corpo da Requisição (Exemplo):

{
  "destinatario": "cliente@example.com",
  "mensagem": "Sua fatura do mês de Setembro já está disponível!",
  "tipoComunicacao": "EMAIL",
  "dataHoraEnvio": "2025-09-30T10:00:00"
}

Resposta de Sucesso (200 OK):

{
  "id": 1,
  "destinatario": "cliente@example.com",
  "mensagem": "Sua fatura do mês de Setembro já está disponível!",
  "tipoComunicacao": "EMAIL",
  "dataHoraEnvio": "2025-09-30T10:00:00"
}

2. Consultar Agendamento
GET /api/agendamentos/{id}

Descrição: Busca um agendamento pelo seu ID.

Resposta de Sucesso (200 OK): Retorna o objeto JSON do agendamento.

Resposta de Erro (404 Not Found): Se o agendamento com o ID especificado não for encontrado.

3. Cancelar Agendamento
DELETE /api/agendamentos/{id}

Descrição: Remove um agendamento existente.

Resposta de Sucesso (204 No Content): O corpo da resposta é vazio, indicando que a operação foi bem-sucedida.

Resposta de Erro (404 Not Found): Se o agendamento com o ID especificado não for encontrado.
