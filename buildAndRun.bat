@echo off
call mvn clean package
call docker build -t com.mycompany/MIPROYECTO .
call docker rm -f MIPROYECTO
call docker run -d -p 9080:9080 -p 9443:9443 --name MIPROYECTO com.mycompany/MIPROYECTO