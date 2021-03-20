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
        stage('Reports') {
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
    }
    post {
       pass {
         mail to: 'aviadamd@gmail.com', subject: 'The Pipeline pass', body:'The Pipeline pass'
       }
    }
}