podTemplate(yaml: """
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: docker
    image: docker:1.11
    command: ['cat']
    tty: true
    volumeMounts:
    - name: dockersock
      mountPath: /var/run/docker.sock
  volumes:
  - name: dockersock
    hostPath:
      path: /var/run/docker.sock
"""
  ) {

  def image = "atrillanes72/team-level-jenkins-jcasc"
  node(POD_LABEL) {
    environment {
    registry = "atrillanes72/team-level-jenkins-jcasc"
    registryCredential = 'dockerhub'
    }
    stage('Build Docker image') {
      git 'https://github.com/sharepointoscar/JCasC.git'
      container('docker') {
        sh "docker build -t ${image} ./master"
      }
    }
  }
}
