**Project Name : POC**

**Technology used**</br>
   • Java 8/n</br>
   • RabbitMQ</br>
   • Spring Boot</br>
   • Camel</br>

**Description :** </br>
  In this project alert/message will be triggered by monitoring tool and pushed to Alert service. Alert service will accept message into JSON format and send alert/message to publisher and subscriber service(pubSubService). PubSub service will apply business logic and push message on queue.</br>
  Consumer will consume message and send to DataBase.
 
**RabbitMQ Installation Steps:**</br>
**STEP 1:** Download Erlang for Windows and RabbitMQ for Windows - https://www.rabbitmq.com/install-windows.html</br>
**STEP 2:** Run otp_win64_22.0.exe as Adminstrator</br>
**STEP 3:** Run rabbitmq-server-3.7.16.exe as Administrator</br>
**STEP 4:** Open Command Prompt and Navigate to %RABBITMQ_HOME%\sbin e.g:> cd "C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.16\sbin"</br>
**STEP 5:** Enable Management Plugin :> rabbitmq_plugins enable rabbitmq_management</br>
**STEP 6:** Open Browser and enter "http://localhost:15672"</br>
**STEP 7:** Enter default credentails to login.</br>
		Username: guest</br>
		Password: guest</br>
**STEP 8:** GOTO Windows Services to START/STOP RabbitMQ Service.</br> AMQP Port: 5672</br>


**Service         - Ports**</br>
Alert Service       -  8080</br>
pubSub Service      -  9090</br>
ITSM Proxy Service  -  8081</br>
AIOPS Proxy Service -  8181</br>


**Example of input JSON for alert/pubSub service:**</br>
{</br>
"customerID":"itsm.x",</br>
"location":"france",</br>
"isSubscriptionOn": true</br>
"Payload":{</br>
"alertPriority":"Urgent",</br>
"assetId":"toto01",</br>
"description":"CPU 99% threshold reached"</br>
}</br>
} </br> 
