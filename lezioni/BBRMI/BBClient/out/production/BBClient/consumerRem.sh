java -cp bin/:../BBRMI_common/jar/BBCommon.jar\
  -Djava.security.policy=client.policy \
  -Djava.rmi.server.codebase=http://YOUR_SERVER_IP_HERE:8080/bblibrary.jar \
   is.boundedbuffer_consumer.ConsumerClient

