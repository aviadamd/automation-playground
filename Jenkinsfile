pipeline {
    agent any
    stages {
        stage('SCM checkout') {
             steps {
                git "https://github.com/aviadamd/automation-playground.git"
             }
             steps {
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
             }
        }
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