FROM java:8-jre
MAINTAINER Madhu Sambangi <madhu.sambangi@gmail.com>

ADD ./target/tutors-account-service-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/tutors-account-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081