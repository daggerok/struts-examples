@echo off
rem https://github.com/AdamBien/wad/releases
rem https://www.youtube.com/watch?v=V_haSihHHV8
rem WAD: 3

if not exist "C:\tmp\wad\wad.jar" (
    mkdir "C:\tmp\wad" 2>nul
    if not errorlevel 1 (
        wget -O "C:\tmp\wad\wad.jar" https://github.com/AdamBien/wad/releases/download/0.1.0/wad.jar
    )
    mkdir "C:\tmp\wad\deployments" 2>nul
)
set TAG=%date:~6,4%-%date:~3,2%-%date:~0,2%-%time:~0,2%-%time:~3,2%-%time:~6,2%
call mvnw.cmd -pl :site
docker build -f ./docker/site/Dockerfile -t daggerok/struts2dolist-site:%TAG% .
docker stop run-struts2dolist-site || true
docker run -d --rm `
    --name run-struts2dolist-site `
    -p 8080:8080 -p 8443:8443 -p 9990:9990 -p 5005:5005 `
    -v /tmp/wad/deployments:/home/jboss/jboss-eap-7.2/standalone/deployments/ `
    daggerok/struts2dolist-site:%TAG%
rem docker logs -f run-struts2dolist-site &

cd site && java -jar /tmp/wad/wad.jar /tmp/wad/deployments
