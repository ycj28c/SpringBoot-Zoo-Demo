# Springboot Zoo Demo [![Build Status](https://travis-ci.org/ycj28c/SpringBoot-Zoo-Demo.svg?branch=master)](https://travis-ci.org/ycj28c/SpringBoot-Zoo-Demo)
A simple demo for springboot & swagger of zoo

Build And Run
-------------
Require maven > 3.0.5, java > 1.6

* Use Maven
Build
```
mvn clean package
```
run
```
java -jar target/bootZoo-0.0.1-SNAPSHOT.jar

# if want to run in different port
java -jar -Dserver.port=9999 target/bootZoo-0.0.1-SNAPSHOT.jar
```
build and run
```
mvn clean package && java -jar target/bootZoo-0.0.1-SNAPSHOT.jar
```

* Use IDE such as eclipse
run com/zoo/ZooApplication.java

Deploy In EC2
-------------
Want to run springboot in AWS ubuntu node as daemon process, please check [59. Installing Spring Boot applications](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html)

1. create a bootzoodemo.service service
```
ubuntu~@$ cd /etc/systemd/system
ubuntu~@$ sudo vi bootzoodemo.service
```
2. add below content to bootzoodemo.service
```
[Unit]
Description=bootzoodemo
After=syslog.target

[Service]
User=ubuntu
ExecStart=/opt/bootZoo/bootZoo-0.0.1-SNAPSHOT.jar
SuccessExitStatus=143

[Install]
WantedBy=multi-user.target
```
if run in different port
```
[Unit]
Description=bootzoodemo
After=syslog.target

[Service]
User=ubuntu
ExecStart=/usr/bin/java -Dserver.port=9999 -jar /opt/bootZoo/bootZoo-0.0.1-SNAPSHOT.jar
SuccessExitStatus=143
Restart=on-failure
RestartSec=5

[Install]
WantedBy=multi-user.target
```

3. register service and run in daemon
```
ubuntu~@$ sudo systemctl enable bootzoodemo.service

#ubuntu~@$ sudo service bootzoodemo start
ubuntu~@$ sudo systemctl start bootzoodemo.service

# check the running status
ubuntu~@$ sudo systemctl status bootzoodemo.service

# stop service
ubuntu~@$ sudo systemctl stop bootzoodemo.service
```

Access Swagger HTML
-------------
http://localhost:8080/swagger-ui.html

or demo here
http://54.219.129.91:9999/swagger-ui.html

HTTP Api Example
-------------
Follow the "RESTful API Design Guide" in [ruanyifeng blog](http://www.ruanyifeng.com/blog/2014/05/restful_api.html "http://www.ruanyifeng.com/blog/2014/05/restful_api.html")

+ GET /zoos：List all the zoos
+ POST /zoos： Add a new zoo
+ GET /zoos/ID：Get information from target zoo  
+ PUT /zoos/ID：Update information for target zoo (must provide all the information)
+ PATCH /zoos/ID：Update information for target zoo (provide parts of information)
+ DELETE /zoos/ID：Delete the target zoo
+ GET /zoos/ID/animals：List all the animals in target zoo
+ DELETE /zoos/ID/animals/ID：Delete the target animal in target zoo


