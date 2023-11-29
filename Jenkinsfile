pipeline {
    agent any
    tools {
             jdk 'OpenJDK 17'
             maven 'Maven3'
             git 'Default'
    }
     environment {
	    APP_NAME = "order-history-tracker"
            RELEASE = "1.0.0"
            DOCKER_USER = "sathishkph"
            IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
            IMAGE_TAG = "${RELEASE}:${BUILD_NUMBER}"
	  }

    stages {
        stage("Cleanup Workspace") {
            steps {
                deleteDir()
            }
        }

        stage("Checkout from SCM") {
               steps {
                   git branch: 'orderhist', credentialsId: 'github', url: 'https://github.com/walmart-2023-sep-ascend/Team08-OrderHistoryTracker'
               }
        }

       stage("Build Application") {
              steps {
                  sh "mvn clean package"  
              }
       }   
       stage("Test Application") {
              steps{
                 sh "mvn test"
              }
      }
        stage("SonarQube Analysis") {
            steps {
                script {
                    withSonarQubeEnv(credentialsId: 'jenkins-sonarqube-token') {
                    sh "mvn sonar:sonar"
                    }
                }
            }
        }
        stage("Quality Gate") {
            steps {
                script {
                    waitForQualityGate abortPipeline: false, credentialsId: 'jenkins-sonarqube-token'
                }
            }
        } 
        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.image("${DOCKER_IMAGE_NAME}").build()
                }
            }
        }
 	stage('Push Docker Image') {
            steps {
                script {
                    // Push Docker image to the registry
                    docker.withRegistry("${DOCKER_REGISTRY_URL}", 'bb459dbc-8478-4d48-a7ed-a827c078906f') {
                        docker.image("${DOCKER_IMAGE_NAME}:latest").push()
			docker.image("${DOCKER_IMAGE_NAME}:${IMAGE_TAG}").push()
                    }
                }
            }   
    }
}
