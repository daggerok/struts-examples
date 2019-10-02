#!/usr/bin/env bash
# https://github.com/AdamBien/wad/releases
# https://www.youtube.com/watch?v=V_haSihHHV8
# WAD: 3
set -euo pipefail

TAG=`date +"%Y%m%d%H%M"`

if [ ! -f /tmp/wad/wad.jar ] ; then
    mkdir -p /tmp/wad /tmp/wad/deployments
    wget -O /tmp/wad/wad.jar https://github.com/AdamBien/wad/releases/download/0.1.0/wad.jar
fi

./mvnw -pl :site
docker build -f ./docker/site/Dockerfile -t daggerok/struts2dolist-site:${TAG} .
docker rm -f -v run-struts2dolist-site || true
docker run -d --rm \
    --name run-struts2dolist-site \
    -p 8080:8080 -p 8443:8443 -p 9990:9990 -p 5005:5005 \
    -v /tmp/wad/deployments:/home/jboss/jboss-eap-7.2/standalone/deployments/ \
    daggerok/struts2dolist-site:${TAG}
docker logs -f run-struts2dolist-site &

cd site && java -jar /tmp/wad/wad.jar /tmp/wad/deployments
