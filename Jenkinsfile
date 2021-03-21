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
                //echo "TEST_CLASS = ${env.TEST_CLASS}"
                //echo "TEST_CLASS = $TEST_CLASS"
                bat "mvn test -P${env.TEST_CLASS}"
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