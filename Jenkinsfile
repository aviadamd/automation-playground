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
                 bat "set platform=\"${env.platform}\""
                 bat "set platformType=\"${env.platformType}\""
                 bat "mvn clean test -Dtest=${env.TEST_CLASS} -DplatformType=${env.platformType}"
             }
        }
    }
}