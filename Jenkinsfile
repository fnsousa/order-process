pipeline {
    agent any
    
    tools { 
        maven 'MAVEN' 
        jdk 'JDK8' 
    }

    stages {

        stage("Checkout Source") {
            steps {
                git url: "https://github.com/fnsousa/order-process.git", branch: "master"
            }
        }

        stage ("Build Bank")  {
            steps {
                sh "mvn clean package -f bank"
            }
        }

        stage ("Build Buy Feedback")  {
            steps {
                sh "mvn clean package -f buyfeedback"
            }
        }

        stage ("Build Buy Process")  {
            steps {
                sh "mvn clean package -f buyprocess"
            }
        }

        stage ("Build Buy Trip")  {
            steps {
                sh "mvn clean package -f buytrip"
            }
        }

    }
}