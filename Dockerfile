FROM amazoncorretto:17

RUN mkdir -p /app

WORKDIR /app

COPY target/checkout-0.0.1-SNAPSHOT.jar .

EXPOSE 8585

CMD ["java", "-jar", "checkout-0.0.1-SNAPSHOT.jar"]
