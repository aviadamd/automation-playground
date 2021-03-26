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
                  echo "${params}"
                  script {
                    def getParams = params  +
                      string(name : PLATFORM, value: "${params.PLATFORM}") +
                      string(name : PLATFORM_TYPE, value: "${params.PLATFORM_TYPE}")
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