pipeline {
    agent any
    tools {
        maven 'maven'
    }

    stages {
        stage('Build JAR File') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Maxahup/Proyecto1_MingesoNuevo.git']]])
                sh 'mvn clean install -DskipTests'
            }
        }
        /*
        stage('Test') {
            steps {

            }
        }
        */
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t maxahumada/proyecto1_mingeso .'     //docker debe estar corriendo
            }
        }
        stage('Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-password', variable: 'dckpass')]) {
                // some block
                    sh 'docker login -u maxahumada -p ${dckpass}'
                }
                sh 'docker push maxahumada/proyecto1_mingeso'
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}