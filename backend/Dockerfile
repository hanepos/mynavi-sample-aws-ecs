# Dockerfile for sample service using embedded tomcat server

# (A)
FROM centos:centos7
# (B)
MAINTAINER hanedan

# (C)
RUN yum install -y \
    java-11-openjdk \
    java-11-openjdk-devel \
    wget tar iproute git

# (D)
RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
# (E)
RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
# (F)
RUN yum install -y apache-maven
# (G)
#ENV JAVA_HOME /etc/alternatives/java_sdk
ENV JAVA_HOME /etc/alternatives/java_sdk_11
RUN alternatives --config javac <<< '1'
RUN alternatives --config java <<< '1'
# (H)
RUN git clone https://github.com/hanepos/mynavi-sample-aws-ecs.git /usr/local/mynavi-sample-aws-ecs
# (I)
RUN mvn -v

RUN mvn install -f /usr/local/mynavi-sample-aws-ecs/backend/pom.xml

# (J)
RUN cp /etc/localtime /etc/localtime.org
# (K)
RUN ln -sf  /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

# (L)
EXPOSE 8080

# (M)
CMD java -jar -Dspring.profiles.active=production /usr/local/mynavi-sample-aws-ecs/backend/target/backend-0.0.1-SNAPSHOT.jar