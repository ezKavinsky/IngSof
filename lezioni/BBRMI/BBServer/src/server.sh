java -cp .:../../artifacts/BBServer_jar/BBCommon.jar \
 -Djava.rmi.server.useCodebaseOnly=false \
 -Djava.security.policy=server.policy \
 -Djava.rmi.server.hostname=YOUR_SERVER_IP_HERE \
-Djava.rmi.server.codebase=http://YOUR_SERVER_IP_HERE:8080/BBCommon.jar is.bbrmi.BoundedBufferServer

