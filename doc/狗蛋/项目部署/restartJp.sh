#!/bin/sh
pi=`jps -l|grep $1 |awk '{print $1}'`
if  [ -n "${pi}" ] ;
then

        echo "kill progress $1 with pid ${pi}"

        kill -9 ${pi}

	kill -9 ${pi}
fi
nohup java -jar ${1} ${2} >${1}.out 2>&1 &
echo `jps -l|grep $1`

