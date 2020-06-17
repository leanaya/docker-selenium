FROM openjdk:8u191-jre-alpine3.8

#WORKSPACE
WORKDIR usr/share/workspace

RUN apk add curl jq

#ADD .jar unde target from host
#into this image
ADD target/selenium-docker.jar        selenium-docker.jar
ADD target/selenium-docker-tests.jar  selenium-docker-tests.jar
ADD target/libs                       libs

#ADD suite files
ADD book-flight-module.xml            book-flight-module.xml
ADD search-module.xml                 search-module.xml

#ADD  healthcheck.sh
RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh

#BROWSER
#HUB_HOST
#MODULE

#Next line was used  when healthcheck.sh was not required
#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG  $MODULE

#Run the healthcheck.sh
ENTRYPOINT sh  healthcheck.sh



   