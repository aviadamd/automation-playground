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
                  echo "set up PLATFORM=${env.PLATFORM}"
                  echo "set up platformType=${env.platformType}"
                  echo "set up platform=${env.platform}"
                  bat "mvn -DplatformType=${env.platformType}"
                  bat "mvn -Dplatform=${env.platform}"
                  bat "mvn clean test -Dtest=${env.TEST_CLASS}"
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