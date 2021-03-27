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
                bat "mvn clean test -Dtest=${env.TEST_CLASS} -Dplatform=${env.platform} -DplatformType=${env.platformType}"
            }
        }
    }
    post {
       always {
           publishHTML ([
               allowMissing: true,
               alwaysLinkToLastBuild: false,
               keepAll: true,
               reportDir: "C:\Users\Lenovo\jenkins\workspace\AUTOMATION_PLAY_GROUND_EXTENT_REPORT\Report",
               reportFiles: "Spark.html",
               reportName: "test report"
           ])
       }
    }
}