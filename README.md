# PurpleCow

Submission by Ed Brown (410-303-5336), edswarchitect@gmail.com

## Dependencies

### Language and Tooling

Open Java Development JDK version 11 was used for building the application.
Specifically, [Amazon Corretto 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html), although not required.



### Web Application

The Jetty Web Application is used to serve the web application. 
[Version 10.0.9 was used and can be downloaded from here.](https://www.eclipse.org/jetty/download.php)

### Docker 

Docker is used as the containerized version

## Installation

```shell

java -jar $JETTY_HOME/start.jar --create-start-d
java -jar $JETTY_HOME/start.jar --add-module=server,http,deploy


```