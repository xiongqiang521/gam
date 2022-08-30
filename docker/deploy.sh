
scp ../gam-service/target/gam-service.jar  root@119.29.40.107/project/gam -i C:/Users/13797/Documents/key
scp ./gam-start.sh root@119.29.40.107/project/gam
ssh root@119.29.40.107 "sh /project/gam/gam-start.sh"
