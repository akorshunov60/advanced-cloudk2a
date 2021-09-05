# Урок 6. homeEx-6:

## Модуль config-server:
---

в файл application.yaml внесены изменения:

server:
port: 8558

spring:
application:
name: config-server
profiles:
active: native
cloud:
config:
server:
git:
uri: file://ClasspathOfYourFile

eureka:
client:
register-with-eureka: false
fetch-registry: false

logging:
level:
com.netflix.eureka: OFF
discovery: OFF

после внесенных изменений модуль загружается.

### Запуск приложения:

1. Загружаем файл docker-compose.yml через терминал Ubuntu 20.04 из папки приложения
    с помощью команды docker-compose up.
   
2. Поочередно загружаем:
    - discovery-service;
    - gateway-service;
    - config-server;
    - product-service;
    - greeting-service;
    - slow-service;
    - front-service;
    
3. При обращении к сервисам через gateway(порт:5555) все сервисы, кроме front-service
    работают без ошибок.
   front-service настроить не удалось.

