pipeline {
    agent {
        kubernetes {
            label 'docker'
            containerTemplate {
                name 'docker'
                image 'docker:1.11'
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
