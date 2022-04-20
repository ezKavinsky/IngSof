java -cp ./:../../../../simpleRMIcommon/out/artifacts/simpleRMIcommon_jar/simpleRMIcommon.jar \
 -Djava.rmi.server.useCodebaseOnly=false -Djava.security.policy=client.policy \
 -Djava.rmi.server.hostname=127.0.0.1 \
   is.simpleRMI.client.SimpleMsgClient
