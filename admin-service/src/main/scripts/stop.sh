#!/bin/bash
#启动主类
MAINCLASS=com.hmsh.admin.start.AdminBootstrap
PWD=$(pwd)
BINDIR=$(cd `dirname $0`;pwd)
BASEDIR=$(cd $BINDIR/..;pwd)
PIDS=`ps -ef | grep java | grep "$BASEDIR" | grep "$MAINCLASS" | grep -v grep |awk '{print $2}'`
if [ -z "$PIDS" ]; then
    echo "ERROR: The $MAINCLASS does not started!"
    exit 0
fi
echo -e "Stopping the $MAINCLASS ...\c"
for PID in $PIDS ; do
    kill $PID > /dev/null 2>&1
done
COUNT=0
while [ $COUNT -lt 1 ]; do
    echo -e ".\c"
    sleep 1
    COUNT=1
    for PID in $PIDS ; do
        PID_EXIST=`ps -f -p $PID | grep java`
        if [ -n "$PID_EXIST" ]; then
            COUNT=0
            break
        fi
    done
done
echo "OK!"
echo "PID: $PIDS"
cd $PWD