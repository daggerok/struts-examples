FROM daggerok/jboss:eap-7.1
HEALTHCHECK --timeout=3s \
            --retries=33 \
            CMD wget -q --spider http://127.0.0.1:8080/my-chat/ || exit 1
ENV JAVA_OPTS="${JAVA_OPTS} \
 -XX:+UnlockExperimentalVMOptions \
 -XX:+UseCGroupMemoryLimitForHeap \
 -XshowSettings:vm \
 -Xms1303m \
 -Xmx1303m \
 -XX:MetaspaceSize=96M \
 -XX:MaxMetaspaceSize=256m \
 -Djava.net.preferIPv4Stack=true \
 -Djboss.modules.system.pkgs=org.jboss.byteman \
 -Djava.awt.headless=true \
 -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
EXPOSE 5005
COPY --chown=jboss-eap-7.1 ./build/libs/*.war ${JBOSS_HOME}/standalone/deployments/
