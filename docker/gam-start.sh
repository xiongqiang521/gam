PID=$(ps -ef |grep java | grep gam-service | grep -v grep | awk '{print $2}')
if test '${PID}'
 then
    echo ${PID}
    kill ${PID}
    sleep 5
fi

nohup java -jar gam-service.jar > /project/gam/log/log.out 2>&1 &
