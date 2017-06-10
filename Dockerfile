M java:8
MAINTAINER email@example.com
#VOLUME /tmp
EXPOSE 8080

ENV USER_NAME stutisrivastv
ENV APP_HOME /home/$USER_NAME/app

RUN useradd -ms /bin/bash $USER_NAME
RUN mkdir $APP_HOME

ADD jvm-learnpipelining.war $APP_HOME/jvm-learnpipelining.war
RUN chown $USER_NAME $APP_HOME/jvm-learnpipelining.war

USER $USER_NAME
WORKDIR $APP_HOME
#RUN bash -c 'touch jvm-learnpipelining.war'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","jvm-learnpipelining.war"]

