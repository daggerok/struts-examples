FROM daggerok/jboss-eap-7.1
HEALTHCHECK --interval=1s \
            --timeout=1s \
            --retries=33 \
            CMD wget -q --spider http://127.0.0.1:8080/webapp/ || exit 1
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
-Djava.awt.headless=true"
COPY --chown=jboss-eap-7.1 ./webapp/target/*.war ${JBOSS_HOME}/standalone/deployments/
