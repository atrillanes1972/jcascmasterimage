pipeline {
    agent {
        kubernetes {
            label 'jenkins-demo'
            containerTemplate {
                name 'dind-jdk8-maven3'
                image 'eu.gcr.io/jenkins-demo/dind-jdk8-maven3:v4'
                ttyEnabled true
                command 'cat'
            }
        }

    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
