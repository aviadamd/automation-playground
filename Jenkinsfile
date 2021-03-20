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
}