#!/bin/bash

checkEnv() {
  if [ -z ${JETTY_HOME} ]; then
    echo "Environment variable JETTY_HOME is unset"
    exit 1
  fi

  if [ -z ${JETTY_BASE} ]; then
    echo "Environment variable JETTY_BASE is unset"
    exit 1
  fi
}


setPort() {
  PORT=3000

  while [[ $# -gt 0 ]]; do
    case $1 in
      -p|--port)
        PORT="$2"
        echo "Port: ${PORT}"
        shift # past argument
        shift # past value
        ;;
      -d|--deploy)
        echo "Building and deploying web app"
        mvn clean package
        cp ./target/PurpleCow.war ${JETTY_BASE}/webapps
        echo "Deployed"
        exit 0
        ;;
      -s | --start)
        startIt
        exit 0
        ;;
      -*|--*)
        echo "Unknown option $1"
        exit 1
        ;;
      *)
        shift # past argument
        ;;
    esac
  done
}

startIt() {
  echo "Starting webapp. <ctrl-c> to stop"
  cd ${JETTY_BASE}
  java -jar $JETTY_HOME/start.jar jetty.http.port=${PORT}
}

checkEnv
setPort "$@"

echo "The port being used: ${PORT}"
startIt


