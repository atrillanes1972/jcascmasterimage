pipeline {
    agent {
        kubernetes {
            label 'maven'
            containerTemplate {
                name 'maven'
                image 'nulldriver:maven-resource'
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
