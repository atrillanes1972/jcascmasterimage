pipeline {
    agent {
        docker {
            image 'docker:1.11' 
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
