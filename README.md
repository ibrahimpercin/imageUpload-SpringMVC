# Spring MVC Image Upload Application Project
This is an example application using Java,Maven,Spring MVC,Bootstrap,Jquery,Ajax,Log4j library for logging and JSP

# Live Demo

http://146.185.160.156:8080/imageupload/

# How to Run

* Download this repository as zip
```
https://bitbucket.org/ibrahimpercin/imageupload/downloads/
```
* In Spring tool suite or Eclipse
```
File - Open project from file system - Archive - choose downloaded zip - Fİnish
```
* Make sure you are using JDK 1.6 and Tomcat or any Java EE server
* You can build the project and run the tests by running ```mvn install and Run on Server```


## Managing maximum image file size
```
src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
```
## Sorting images
```
src/main/java/imageService
    sort() method
```
## Viewing fullscreen images

* Javascript and Ajax
```
src/main/webapp/resources/js/custom.js
```
* Java codes for increasing image views value
```
src/main/java/imageService
    increaseImageViews()
```
* Java codes for updating image views from jsp and getting new views value on jsp 
```
src/main/java/imageController
    increaseImageViews()
```
## Logging example
```
src/main/java/imageService
    Logger
```
## Managing maximum number of images from property file
```
src/main/java/imageService
    checkImages()
```