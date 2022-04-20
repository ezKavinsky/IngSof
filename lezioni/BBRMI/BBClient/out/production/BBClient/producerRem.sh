java -cp .:../../../../BBCommon/out/artifacts/BBCommon_jar/BBCommon.jar \
 -Djava.security.policy=client.policy \
 -Djava.rmi.server.codebase=http://YOUR_SERVER_IP_HERE:8080/bblibrary.jar \
  is.boundedbuffer_producer.ProducerClient
