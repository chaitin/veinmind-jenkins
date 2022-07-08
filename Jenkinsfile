@Library('veinmind-runner') _

pipeline {
    agent {
         docker {
              image 'docker:latest'
         }
    }

    stages {
        stage('build') {
            steps {
                script {
                    sh 'docker pull ubuntu'
                    sh 'docker build -t weak:latest -f test/Dockerfile .'
                }
            }
        }

        stage('scan-success') {
            steps {
                script {
                    veinmindRunner.scan("ubuntu:latest")
                }
            }
        }

        stage('scan-unblock') {
            steps {
                script {
                    veinmindRunner.scan("weak:latest")
                }
            }
        }

        stage('unusual-test') {
            steps {
                script {
                    veinmindRunner.scan("weak:latest", outPut="report1.json")
                }
            }
        }

        stage('unusual-test2') {
            steps {
                script {
                    veinmindRunner.scan("weak:latest", outPut="report2.json", exitCode=0)
                }
            }
        }

        stage('unusual-test3') {
            steps {
                script {
                    veinmindRunner.scan("weak:latest","scan-host", "report3.json")
                }
            }
        }

        stage('unusual-test4') {
            steps {
                script {
                    veinmindRunner.scan("weak:latest","scan-host", "report4.json", 0)
                }
            }
        }

        stage('scan-block') {
            steps {
                script {
                    veinmindRunner.scan("weak:latest", 1)
                }
            }
        }
    }
}