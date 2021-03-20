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
            steps {
                dir("target") {
                   bat "java -jar automation-playground.tests.jar"
                }
            }
        }
    }
}