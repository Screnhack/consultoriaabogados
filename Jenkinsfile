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
    gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
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
				gitTool: 'Git_Centos', 
				submoduleCfg: [], 
				userRemoteConfigs: [[
				credentialsId: 'GitHub_Screnhack', 
					url:'https://github.com/Screnhack/consultoriaabogados.git'
				]]
			])
      }
    }
   	stage('Build project') {
    	steps {
        	echo "------------>Building project<------------"
            sh 'gradle --b ./build.gradle clean'
            sh 'gradle --b ./build.gradle build'
        }
    }
                        stage('Compile & Unit Tests') {
                           steps {
                              echo "--------------->Unit Tests<--------"
                              sh 'gradle --b ./build.gradle test'
                              sh 'gradle --b ./build.gradle jacocoTestReport'
                           }
                        }
                        stage('Static Code Analysys'){
                           steps {
                              echo '----------------->Analisis de Código estático<-----------------'
                              withSonarQubeEnv('Sonar'){
                                 sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties -Dsonar.java.libraries=/home/ic/.gradle/caches/modules-2/files-2.1/**/*.jar"
                              }
                           }
                        }
                        stage('Build') {
                           steps {
                              echo "-------->Build<---------"
                              sh 'gradle --b ./build.gradle build -x test'
                           }
                        }  
  }

  post {
    failure {
		echo 'This will run only if failed'
		mail (to: 'andres.villamizar@ceiba.com.co',
		subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
		body: "Something is wrong with ${env.BUILD_URL}")
	}
	success {
			echo 'This will run only if successful'
			junit 'build/test-results/test/*.xml' 
		}
  }
}
