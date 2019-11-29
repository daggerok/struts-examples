# WAD: 1
FROM daggerok/jboss-eap-7.2:7.2.0-alpine
ENTRYPOINT ${JBOSS_HOME}/bin/standalone.sh -b 0.0.0.0
ENV JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
EXPOSE 5005 8080 8443 9990
HEALTHCHECK --retries=33 \
            --timeout=3s \
            --interval=3s \
            --start-period=3s \
            CMD wget -q --spider http://127.0.0.1:8080/site/ || exit 1
COPY --chown=jboss ./site/target/*.war ${JBOSS_HOME}/standalone/deployments/site.war
