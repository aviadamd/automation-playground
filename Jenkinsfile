pipeline {
    agent any
    environment {
        TEST_CLASS = "AccountManagementTest"
    }
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Run Tests') {
            steps {
                echo "TEST_CLASS =${env.TEST_CLASS}"
                bat "mvn test -P${env.TEST_CLASS}"
                //bat "mvn clean test"
            }
        }
    }
    post {
       always {
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