pipeline {
    agent {
        docker {
            image 'dind-jenkins-agent' 
            args '-v /var/run/docker.sock:/var/run/docker.sock' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'docker version' 
            }
        }
    }
}
