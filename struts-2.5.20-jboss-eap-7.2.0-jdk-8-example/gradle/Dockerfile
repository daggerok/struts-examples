FROM daggerok/jboss-eap-7.2
HEALTHCHECK --retries=33 \
            --timeout=3s \
            --interval=3s \
            --start-period=3s \
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
RUN echo "JAVA_OPTS=\"\$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \"" >> ${JBOSS_HOME}/bin/standalone.conf
EXPOSE 5005
COPY --chown=jboss ./build/libs/*.war ${JBOSS_HOME}/standalone/deployments/
