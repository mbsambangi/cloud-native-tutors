FROM java:8-jre
MAINTAINER Madhu Sambangi <madhu.sambangi@gmail.com>

ADD ./target/tutors-eureka-service-0.0.1-SNAPSHOT.jar /app/tutors-eureka-service.jar
CMD ["java", "-Xmx200m", "-jar", "/app/tutors-eureka-service.jar"]

# HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/health || exit 1

EXPOSE 8761