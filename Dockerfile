FROM jenkinsci/jenkins:lts
ARG DOCKER_GROUP_ID 
USER root
RUN apt-get update -qq \
    && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common 
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"
RUN apt-get install docker-ce=18.03.1~ce-0~debian -y
RUN groupadd -g $DOCKER_GROUP_ID docker && gpasswd -a jenkins docker
RUN usermod -aG docker jenkins
