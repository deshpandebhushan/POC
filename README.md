#Project Name : POC
#Technology used
   • Java 8
   • RabbitMQ
   • Spring Boot
   • Camel

#Description :  
  In this project alert/message will be triggered by monitoring tool and pushed to Alert service. Alert service will accept message into JSON format and send alert/message to publisher and subscriber service(pubSubService). PubSub service will apply business logic and push message on queue.
  Consumer will consume message and send to DataBase.
 
#RabbitMQ Installation Steps:
STEP 1: Download Erlang for Windows and RabbitMQ for Windows - https://www.rabbitmq.com/install-windows.html
STEP 2: Run otp_win64_22.0.exe as Adminstrator
STEP 3: Run rabbitmq-server-3.7.16.exe as Administrator
STEP 4: Open Command Prompt and Navigate to %RABBITMQ_HOME%\sbin e.g:> cd "C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.16\sbin"
STEP 5: Enable Management Plugin :> rabbitmq_plugins enable rabbitmq_management
STEP 6: Open Browser and enter "http://localhost:15672"
STEP 7: Enter default credentails to login.
		Username: guest
		Password: guest
STEP 8: GOTO Windows Services to START/STOP RabbitMQ Service. AMQP Port: 5672


#Service         - Ports
Alert Service       -  8080
pubSub Service      -  9090
ITSM Proxy Service  -  8081
AIOPS Proxy Service -  8181


#Example of input JSON for alert/pubSub service:
{
"customerID":"itsm.x",
"location":"france",
"isSubscriptionOn": true
"Payload":{
"alertPriority":"Urgent",
"assetId":"toto01",
"description":"CPU 99% threshold reached"
}
}  
