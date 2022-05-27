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

1. Install Jetty as instructed in the Jetty documentation. ***Note***: 

The `JETTY_HOME` environment variable ***MUST*** be set to the installation of Jetty, for the application scripts
to work. The `JETTY_BASE` environment ***MUST*** be set to a directory that can be used to deploy the web application and
configure the run time for Jetty.

2. In the installation directory of this application, there is a script `purple-cow.sh`, that is used to initialize the
web server, deploy the web application, and run the web application. The following are the commands:

* `./purple-cow.sh  [ -i | --init ]` - Initializes the web server for use.
* `./purple-com.sh [ -d | --deply ]` - Compiles and deploys the web application to Jetty.

## Execution 

### Command Line Execution

To run the application enter the following command.
If the port option isn't specified, it defaults to port 3000

```shell
./purple-com.sh [ -p  <port no> | --port <port no> ]
``` 

Then uses the web browser to go to the following url:
`http://localhost:<port>//PurpleCow`

### Docker Execution

1. Build the image using the Dockerfile in this distribution: 
`docker build . -t purple-cow-counter`
2. Run the Docker image built, using a port you specify: `docker run -p 9999:8080 purple-cow-counter`
3. Use the web browser at the specified URL: `http://localhost:9999//PurpleCow`