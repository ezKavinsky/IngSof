java -cp ./:../../../../simpleRMIcommon/out/artifacts/simpleRMIcommon_jar/simpleRMIcommon.jar \
 -Djava.rmi.server.useCodebaseOnly=false -Djava.security.policy=server.policy \
 -Djava.rmi.server.hostname=127.0.0.1 \
  -Djava.rmi.server.codebase="http://160.97.24.119:8080/simpleRMIserver.jar http://160.97.24.119:8080/simpleRMIcommon.jar" \
 is.simpleRMI.server.app.SimpleMsgServer
