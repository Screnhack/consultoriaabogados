pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle5.0_Centos' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
	       checkout([
				$class: 'GitSCM', 
				branches: [[name: '*/master']], 
				doGenerateSubmoduleConfigurations: false, 
				extensions: [], 
				gitTool: 'Default', 
				submoduleCfg: [], 
				userRemoteConfigs: [[
				credentialsId: 'GitHub_Screnhack', 
					url:'https://github.com/Screnhack/consultoriaabogados'
				]]
			])
      }
    }
    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
			sh 'gradle --b ./build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
			sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        sh 'gradle --b ./build.gradle build -x test'
      }
    }  
  }

  post {
    failure {
		echo 'This will run only if failed'
		mail (to: 'andres.villamizar@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
	}
	success {
		echo 'This will run only if successful'
		junit 'build/jacoco/test.exec' 
	}
  }
}
