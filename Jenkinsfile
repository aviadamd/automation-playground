pipeline {
    agent any
    parameters {
       string(name : 'PLATFORM', description : 'Param 1?')
       string(name : 'PLATFORM_TYPE', description : 'Param 1?')
    }
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Run Tests') {
            steps {
                  echo "set up PLATFORM = ${env.PLATFORM}"
                  echo "set up PLATFORM_TYPE = ${env.PLATFORM_TYPE}"
                  echo "set up TEST_CLASS = ${env.TEST_CLASS}"
                  script {
                    def getParams = parameters  +
                      string(name : PLATFORM, value: "${parameters.PLATFORM}") +
                      string(name : PLATFORM_TYPE, value: "${parameters.PLATFORM_TYPE}")
                      build job 'downstream-pipeline-with-params', parameters : getParams
                  }
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