pipeline {
  agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "JenkinsMaven"
        snyk "SnykTool"
        git "Default"
    }
  stages {
    stage('Checkout') {
      steps {
        sh 'echo "checkout"'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
stage('Test') {
      steps {
        echo 'Testing...'
        snykSecurity failOnIssues: false, snykInstallation: 'SnykTool', snykTokenId: 'Snyk Token'
      }
    }
    //Sonarqube Test
    stage('Quality') {
        steps{
            //def mvn = tool 'JenkinsMaven';
            sh 'pwd'
            withSonarQubeEnv( installationName: 'SonarQubeConnection' ,credentialsId: 'SonarQubeToken') {
                sh "/var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/JenkinsMaven/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Prova"
            }
        }
      }
    stage('Deploy') {
      steps {
        emailext body: 'Please check the SonarQube and Snyk Reports, to assess the found vulnerabilities using SAST, and decide to Approve or Reject the deployment of the artifact into production.', recipientProviders: [buildUser()], subject: 'Sonarqube and Snyk Reports', to: 'gius.dagostino@reply.it'
        input 'Proceed with deployment?'
        deploy adapters: [tomcat9(credentialsId: 'Tomcat-Admin-Cred', path: '', url: 'http://localhost:8080')], contextPath: 'Sample-WebApp', war: 'target/Sample-WebApp.war'
        archiveArtifacts artifacts: 'target/Sample-WebApp.war', followSymlinks: false
      }
    }
  }
}
