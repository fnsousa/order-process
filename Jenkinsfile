pipeline {
    agent any
    
    tools { 
        maven 'MAVEN' 
        jdk 'JDK8' 
    }

    stages  {

        stage('Checkout Source') {
            steps {
                git url: 'https://github.com/fnsousa/order-process.git', branch: 'master'
            }
        }

        stage ('Build Bank')  {
            steps {
                sh 'mvn clean package -f bank'
            }
        }

        stage ('Build Buy Feedback')  {
            steps {
                sh 'mvn clean package -f buyfeedback'
            }
        }

        stage ('Build Buy Process')  {
            steps {
                sh 'mvn clean package -f buyprocess'
            }
        }

        stage ('Build Buy Trip')  {
            steps {
                sh 'mvn clean package -f buytrip'
            }
        }

        stage ('Build image Bank')  {
            steps {
                script {
                    dockerAppBank = docker.build("felipenascimmento/bank:${env.BUILD_ID}", '-f ./bank/Dockerfile .')
                }
            }
        }

        stage ('Build image Buy Feedback')  {
            steps {
              script {
                    dockerAppBuyFeedback = docker.build("felipenascimmento/buyfeedback:${env.BUILD_ID}", '-f ./buyfeedback/Dockerfile .')
                }
            }
        }

        stage ('Build image Buy Process')  {
            steps {
                script {
                    dockerAppBuyProcess = docker.build("felipenascimmento/buyprocess:${env.BUILD_ID}", '-f ./buyprocess/Dockerfile .')
                }
            }
        }

        stage ('Build image Buy Trip')  {
            steps {
               script {
                    dockerAppBuyTrip = docker.build("felipenascimmento/buytrip:${env.BUILD_ID}", '-f ./buytrip/Dockerfile .')
                }
            }
        }

        stage ('Push Image Bank') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                       dockerAppBank.push('latest')
                       dockerAppBank.push("${env.BUILD_ID}")
                    }
                }
            }
        }
        

        stage ('Push Image Buy Feedback')  {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                       dockerAppBuyFeedback.push('latest')
                       dockerAppBuyFeedback.push("${env.BUILD_ID}")
                    }
                }
            }
        }

        stage ('Push Image Buy Process')  {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                       dockerAppBuyProcess.push('latest')
                       dockerAppBuyProcess.push("${env.BUILD_ID}")
                    }
                }
            }
        }

        stage ('Push Image Buy Trip')  {
            steps {
               script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                       dockerAppBuyTrip.push('latest')
                       dockerAppBuyTrip.push("${env.BUILD_ID}")
                    }
                }
            }
        }

    }
}