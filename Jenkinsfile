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
                 echo "set up TEST_CLASS = ${env.TEST_CLASS}"
                 bat "mvn clean test -Dtest=${env.TEST_CLASS}"
            }
        }
    }
}