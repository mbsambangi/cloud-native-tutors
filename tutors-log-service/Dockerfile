FROM java:8-jre
MAINTAINER Madhu Sambangi <madhu.sambangi@gmail.com>

ADD ./target/tutors-log-service-0.0.1-SNAPSHOT.jar /app/tutors-log-service.jar
CMD ["java", "-Xmx200m", "-jar", "/app/tutors-log-service.jar"]

# HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/health || exit 1

EXPOSE 8889