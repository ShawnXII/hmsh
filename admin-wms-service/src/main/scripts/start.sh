#!/bin/bash
#启动主类
MAINCLASS=com.hmsh.admin.start.AdminWmsBootstrap
JAVA_OPTS="${java.mem.config} -Djava.net.preferIPv4Stack=true -Dfile.encoding=utf-8"
type java >/dev/null 2>&1 || { echo >&2 "I require java but it's not installed.Aborting."; exit 1; }
PWD=$(pwd)
BINDIR=$(cd `dirname $0`;pwd)
BASEDIR=$(cd $BINDIR/..;pwd)
LOGSDIR=$BASEDIR/logs
if [ ! -d $LOGSDIR ]; then
    mkdir $LOGSDIR
fi
STDOUTLOG=$LOGSDIR/stdout.log
cd $BASEDIR
CLASSPATH=$BASEDIR/classes
for i in "$BASEDIR"/lib/*.jar; do
   CLASSPATH="$CLASSPATH":"$i"
done
PIDS=`ps -ef | grep java | grep "$BASEDIR" | grep "$MAINCLASS" | grep -v grep |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $MAINCLASS already started!"
    echo "PID: $PIDS"
    exit 1
fi
echo -e "Starting $MAINCLASS ...\c"
nohup java $JAVA_OPTS -classpath $CLASSPATH $MAINCLASS >$STDOUTLOG 2>&1 &
COUNT=0
sleep 3
while [ $COUNT -lt 1 ]; do
    echo -e ".\c"
    sleep 1
    COUNT=`ps -f | grep java | grep "$BASEDIR" | grep "$MAINCLASS" | grep -v grep |awk '{print $2}' | wc -l`
    if [ $COUNT -gt 0 ]; then
        break
    fi
done
echo "OK!"
PIDS=`ps -ef | grep java | grep "$BASEDIR" | grep "$MAINCLASS" | grep -v grep |awk '{print $2}'`
echo "PID: $PIDS"
cd $PWD