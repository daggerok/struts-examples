FROM daggerok/jboss-eap-6.4:6.4.22-centos
HEALTHCHECK --retries=33 \
            --timeout=3s \
            --interval=3s \
            --start-period=3s \
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
 -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 "
EXPOSE 5005
COPY --chown=jboss ./build/libs/*.war ${JBOSS_HOME}/standalone/deployments/
