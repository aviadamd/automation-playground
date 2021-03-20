pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Run Tests') {
            steps {
                bat "mvn clean test"
            }
        }
    }
    post {
       stage('reports') {
           steps {
           script {
               allure([
                      includeProperties: false,
                      jdk: '',
                      properties: [],
                      reportBuildPolicy: 'ALWAYS',
                      results: [[path: 'target/allure-results']]
               ])
           }
           }
       }
       failure {
         mail to: 'aviadamd@gmail.com', subject: 'The Pipeline pass', body:'The Pipeline pass'
       }
    }
}