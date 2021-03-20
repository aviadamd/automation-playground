pipeline {
    agent any
    tools {
       maven 'Maven 3.6.3'
    }
    stages {
        stage('SCM checkout') {
             steps {
                git "https://github.com/aviadamd/automation-playground.git"
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
             }
        }
        stage('Build Jar') {
            steps {
                timeout(time: 3, unit: 'SECONDS') {
                   retry(1) {
                     echo "wait for build jar"
                   }
                }
            }
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Run Tests') {
            steps {
                bat "mvn clean test"
                dir("target") {
                   bat "java -jar automation-playground.tests.jar"
                }
            }
        }
        post {
            success {
               archiveArtifacts 'target/*.jar'
            }
        }
    }
}