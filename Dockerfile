FROM openjdk:8-jre

# Install apt-transport-https; otherwise, custom APT https repositories will not work.
RUN apt-get update \
    && apt-get install -y apt-transport-https

# Install SBT
RUN echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list \
    && apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823 \
    && apt-get update \
    && apt-get install -y sbt

# Work in a server directory
RUN mkdir /var/srv
WORKDIR /var/srv

# Copy project and compile
COPY . /var/srv
RUN sbt compile

ENTRYPOINT ["sbt"]
CMD ["run"]
