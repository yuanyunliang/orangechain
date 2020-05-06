From 192.168.10.233:8803/oracle-jdk-8
#build with "mvn package spring-boot:repackage"
COPY target/webapp.jar webapp.jar
EXPOSE 9999
EXPOSE 20999
CMD java -jar webapp.jar