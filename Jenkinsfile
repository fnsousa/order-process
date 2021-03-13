pipeline {
    agent any
    
    tools { 
        maven 'MAVEN' 
        jdk 'JDK8' 
    }

    stages {

        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage("Checkout Source") {
            steps {
                git url: "https://github.com/fnsousa/order-process.git", branch: "master"
            }
        }

        stage ("Build bank")  {
            steps {
                sh "mvn clean package -f bank"
            }
        }
    }
}