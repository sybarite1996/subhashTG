pipeline {
    agent any
    stages {
        stage('getting TG') {
            steps {
            sh ./pract.sh
              }
             }
            }
            }
