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
       always {
          testng 'target/surefire-reports/TEST-*.xml'
       }
       failure {
         mail to: 'aviadamd@gmail.com', subject: 'The Pipeline pass :(', body:'The Pipeline pass'
       }
    }
}