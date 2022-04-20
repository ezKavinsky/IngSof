java -cp bin/:../BBRMI_common/jar/BBCommon.jar\
  -Djava.security.policy=client.policy \
  -Djava.rmi.server.codebase=http://160.97.24.119:8080/bblibrary.jar \
   is.boundedbuffer_consumer.ConsumerClient

