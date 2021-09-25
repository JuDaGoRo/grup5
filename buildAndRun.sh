#!/bin/sh
mvn clean package && docker build -t com.mycompany/MIPROYECTO .
docker rm -f MIPROYECTO || true && docker run -d -p 9080:9080 -p 9443:9443 --name MIPROYECTO com.mycompany/MIPROYECTO