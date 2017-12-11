#!/bin/bash

SELENIUM=/opt/selenium/selenium-server-standalone-2.41.0.jar
PORT=4444
PIDFILE=/tmp/selenium-server.pid
OUTPUT_LOG=/var/log/selenium/selenium-output.log
ERROR_LOG=/var/log/selenium/selenium-error.log

# Start the Selenium server
start() {
  selenium_running
  if [[ $RUNNING -gt 0 ]];
	then
		echo "Selenium is already running"
	else
		export DISPLAY=":99" && java -Xmx2048m -jar $SELENIUM -port $PORT -avoidProxy -Dhttp.proxyHost=10.3.50.230 -Dhttp.proxyPort=8080 -Dhttp.auth.preference=Basic -debug  -Dwebdriver.firefox.profile=behat -trustAllSSLCertificates '*firefox /usr/bin/firefox' > $OUTPUT_LOG 2> $ERROR_LOG &
        	### Create the lock file ###
		echo "Starting Selenium server!"
        	echo $! > $PIDFILE
	fi
        exit 0
}

# Stop the selenium server.
stop() {
   selenium_running
   if [[ $RUNNING -gt 0 ]];
   then
    echo "Stopping Selenium server..."
    HOST="http://localhost:$PORT/selenium-server/driver/?cmd=shutDownSeleniumServer"
    curl $HOST

    ### Now, delete the PID file ###
    rm -f $PIDFILE
	else
		echo "Selenium is not running"
	fi
}

function selenium_running() {
  RUNNING=`netstat -ant | awk '$6 == "LISTEN" && $4 == ":::4445"' | wc -l`
}

### main logic ###
case "$1" in
  start)
        start
        ;;
  stop)
        stop
        ;;
  status)
        selenium_running
        echo $RUNNING
        ;;
  restart|reload|condrestart)
        stop
        start
        ;;
  *)
        echo $"Usage: $0 {start|stop|restart|reload|status}"
        exit 1
esac

exit 0
