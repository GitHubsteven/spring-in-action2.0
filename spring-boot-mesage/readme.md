JMS is an API and AMQP is a protocol

The JMS client, which implements the JMS API can use whatever protocol to communicate against the JMS server.
 However the JMS client needs to make sure to be compliant with the JMS API. That's it.

AMQP on other hand is nothing but a protocol between a messaging client and the messaging server.
 So a JMS client can use AMQP as the protocol to communicate with the messaging server.