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
        input 'Proceed with deployment?'
        sh 'cd /opt/tomcat/bin && ./shutdown.sh'
       // sh './shutdown.sh'
        sh 'rm -rf /opt/tomcat/webapps/Sample-WebApp*'
        deploy adapters: [tomcat9(credentialsId: 'Tomcat-Creds', path: '', url: 'http://localhost:8080/')], contextPath: 'Sample-WebApp', war: 'target/*.war'
        //sh 'cp target/*.war /opt/tomcat/webapps'
        sh 'cd /opt/tomcat/bin && ./startup.sh'
      }
    }
  }
}
