# tech-challenge-java - Checkout
 
# Lanchonete Fast Food - Sistema de Gerenciamento de Produtos   

## Descrição
 
Este projeto faz parte de um sistema de autoatendimento de fast food desenvolvido para uma lanchonete em expansão. 

## Características - microservices checkout

- **Pagamento do pedido**: Realizar o pagamento atraves de uma api simulando uma comunicacao com o mercado pago
- **Webhook pagamento**: Atualiza em tempo real o status do pagamento.

## Tecnologias Utilizadas 

- **Linguagem**: Java
- **Framework**: Spring Boot
- **Banco de Dados**: PostgreSQL
- **ORM**: Hibernate

## Como Rodar o Projeto com docker

1. **Pré-requisitos**:
   - Java JDK 17
   - Maven instalado
   - Docker instalado e em execução

2. Rode o comando `mvn clean package` na raiz do projeto para gerar o arquivo .jar

3. Em seguida rode o comando `docker compose up` para iniciar os containers do banco de dados e da aplicação
