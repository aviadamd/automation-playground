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
                  echo "set up PLATFORM=${env.platform}"
                  echo "set up PLATFORM_TYPE=${env.platformType}"
                  bat  "set platform=\"${env.PLATFORM}\""
                  bat  "set platformType=\"${env.PLATFORM_TYPE}\""
                  bat  "mvn clean test -Dtest=${env.TEST_CLASS}"
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