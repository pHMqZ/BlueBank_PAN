FROM openjdk:11

ARG PROFILE=${PROFILE}
ARG ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/bluebank

COPY /target/BlueBank-API*.jar api_bluebank_docker.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8000

CMD java ${ADDITIONAL_OPTS} -jar api_bluebank_docker.jar --spring.profiles.active=${PROFILE}
