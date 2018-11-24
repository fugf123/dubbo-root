#!/bin/sh

##定义环境变量
export JAVA_HOME=/usr/local/java/jdk1.7.0_72
export JRE_HOME=${JAVA_HOME}/jre

##service name
APP_NAME=user

##服务目录文件
SERVICE_DIR=/home/wuse/edu/service/$APP_NAME
SERVICE_NAME=edu-service-$APP_NAME
##jar名称
JAR_NAME=$SERVICE_NAME\.jar
##服务进程文件名称
PID=$SERVICE_NAME\.pid

## 首先进入到项目目录
cd $SERVICE_DIR
##命令参数
case "$1" in

    start)
        nohub $JRE_HOME/bin/java -Xms256m -jar $JAR_NAME>/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID
        echo "=== start $SERVICE_NAME"
        ;;
    stop)
        kill `cat $SERVICE_DIR/$PID`
        rm -rf $SERVICE_DIR/$PID
        echo "=== stop $SERVICE_NAME"

        sleep $    ##  -w 全匹配
        P_ID= ps -ef | grep -w "$SERVICE_NAME" grep  -v "grep" | awk `{print $2}`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME process not exist or stop success"
         else
            echo "===$SERVICE_NAME process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME process,pid is:$P_ID"
            kill -9 $P_ID
         fi
        ;;
     restart)
        $0 stop
        sleep 2
        $0 start
        echo "=== restart $SERVICE_NAME"
        ;;
    *)
        ##restart
        $0 stop
        sleep 2
        $0 start
        ;;

esac
exit 0
