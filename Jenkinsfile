pipeline {
    agent any
    tools {
             jdk 'OpenJDK 17'
             maven 'Maven3'
             git 'Default'
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
                    waitforQualityGate abortPipeline: false, credentialsId: 'jenkins-sonarqube-token') 
                }
            }
        }    
    }
}
