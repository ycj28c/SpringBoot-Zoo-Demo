# Springboot Zoo Demo
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
java -jar target/boot-0.0.1-SNAPSHOT.jar
```
build and run
```
mvn clean package && java -jar target/boot-0.0.1-SNAPSHOT.jar
```

* Use IDE such as eclipse
run com/zoo/ZooApplication.java

Access Swagger HTML
-------------
http://localhost:8080/swagger-ui.html

HTTP Api Example
-------------
Follow the "RESTful API Design Guide" in [ruanyifeng blog](http://www.ruanyifeng.com/blog/2014/05/restful_api.html "http://www.ruanyifeng.com/blog/2014/05/restful_api.html")

  GET /zoos：List all the zoos
  POST /zoos： Add a new zoo
  GET /zoos/ID：Get information from target zoo
  PUT /zoos/ID：Update information for target zoo (must provide all the information)
  PATCH /zoos/ID：Update information for target zoo (provide parts of information)
  DELETE /zoos/ID：Delete the target zoo
  GET /zoos/ID/animals：List all the animals in target zoo
  DELETE /zoos/ID/animals/ID：Delete the target animal in target zoo
