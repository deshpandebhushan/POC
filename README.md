POC (Camel + Spring Boot + RabbitMQ)

Camel is an open source integration framework that empowers you to quickly and easily integrate various systems consuming or producing data.
Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
RabbitMQ is an open-source message-broker software. The RabbitMQ server program is written in the Erlang programming language.

RabbitMQ Setup:

1. Install esl-erlang_22.1_windows_amd64.exe file
2. Add to system variables and path variables of above file
3. Install rabbitmq-server-3.8.2.exe file now
4. Enable rabbitmq management plugin-(USE THIS COMMAND--- rabbitmq-plugins.bat enable rabbitmq_management)
5. http://localhost:15672 (guest as username and password)

Ports:

Alert Service- 8080
pubSub Service- 9090
ITSM Proxy Service- 8081
AIOPS Proxy Service- 8181

Message Sample:

{
"customerID":"itsm.x",
"location":"france",
“isSubscriptionOn”: true
"Payload":{
"alertPriority":"Urgent",
"assetId":"toto01",
"description":"CPU 99% threshold reached"
}
}  
