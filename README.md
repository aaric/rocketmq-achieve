# rocketmq-achieve

[![License](https://img.shields.io/badge/License-MIT-green.svg?style=flat&logo=github)](https://www.mit-license.org)
[![JDK](https://img.shields.io/badge/JDK-1.8u202-brightgreen.svg?style=flat&logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![JUnit](https://img.shields.io/badge/JUnit-5.6.2-brightgreen.svg?style=flat&logo=junit5)](https://junit.org/junit5/docs/current/user-guide)
[![Gradle](https://img.shields.io/badge/Gradle-7.2-brightgreen.svg?style=flat&logo=gradle)](https://docs.gradle.org/7.2/userguide/installation.html)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.3.2-brightgreen.svg?style=flat&logo=springboot)](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/)
[![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-Hoxton.SR9-brightgreen.svg?style=flat&logo=spring)](https://docs.spring.io/spring-cloud/docs/Hoxton.SR9/reference/htmlsingle/)
[![Spring Cloud Alibaba](https://img.shields.io/badge/Spring_Cloud_Alibaba-2.2.6-brightgreen.svg?style=flat&logo=alibabacloud)](https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/zh-cn/index.html)
[![Release](https://img.shields.io/badge/Release-0.2.0-blue.svg)](https://github.com/aaric/rocketmq-achieve/releases)

> RocketMQ Learning.

## 1 Install

> [rocketmq-all-4.4.0-bin-release.zip](https://archive.apache.org/dist/rocketmq/4.4.0/rocketmq-all-4.4.0-bin-release.zip)

### 1.1 NameServer

```bash
# port | 9876 -> 10876
cat > conf/namesrv.conf <<-'EOF'
listenPort=10876
EOF

# start
#nohup bin/mqnamesrv -c conf/namesrv.conf > /dev/null 2>&1 &
nohup bin/mqnamesrv -c conf/namesrv.conf > namesrv.log 2>&1 &

# shutdown
bin/mqshutdown namesrv
```

### 1.2 Broker

```bash
# mem | runbroker.sh
vim bin/runbroker.sh
'''
JAVA_OPT="${JAVA_OPT} -server -Xms256m -Xmx256m -Xmn128m"
'''

# mem | runserver.sh
vim bin/runserver.sh
'''
JAVA_OPT="${JAVA_OPT} -server -Xms256m -Xmx256m -Xmn128m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"
'''

# port | 10911 -> 11911
cat >> conf/broker.conf <<-'EOF'

# custom
listenPort=10876
EOF

# start
#nohup bin/mqbroker -n 10.0.11.25:10876 -c conf/broker.conf > /dev/null 2>&1 &
nohup bin/mqbroker -n 10.0.11.25:10876 -c conf/broker.conf > broker.log 2>&1 &

# shutdown
bin/mqshutdown broker
```

### 1.3 Testing

```bash
# env
export NAMESRV_ADDR=10.0.11.25:10876

# producer
bin/tools.sh org.apache.rocketmq.example.quickstart.Producer

# consumer
bin/tools.sh org.apache.rocketmq.example.quickstart.Consumer
```
