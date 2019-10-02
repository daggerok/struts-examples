# Struts 2 CDI JBoss EAP

_unix_

```bash
./wad-docker.sh
```

_or_

```bash
./mvnw -pl :docker docker-compose:down \
; ./mvnw -pl :docker docker-compose:up \
; ( docker logs -f -t docker_site_1 & ) \
; while [[ $(docker ps -lq --filter=health=healthy  | wc -l) -lt 1 ]] ; do echo -ne '.' ; sleep 1s ; done
```

open https://127.0.0.1:8443/site/

_links_

* https://blog.sebastian-daschner.com/entries/reloading-javaee-apps-wad
* https://github.com/AdamBien/wad/releases
* https://www.youtube.com/watch?v=V_haSihHHV8
* https://github.com/daggerok/jboss-eap-7.2
* https://github.com/dkanejs/docker-compose-maven-plugin
* https://struts.apache.org/plugins/convention/#code-behind-hello-world
* https://struts.apache.org/getting-started/how-to-create-a-struts2-web-application.html
* https://blog.eisele.net/2015/01/ssl-with-wildfly-8-and-undertow.html
* https://dzone.com/articles/http2-with-jboss-eap-7-tech-preview

