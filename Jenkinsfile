pipeline{
	
		agent {
			label 'Slave_Induccion'
		}
	
        
		tools {
			jdk 'JDK8_Centos' 
			gradle 'Gradle5.0_Centos' 
		}
	
		options {
			buildDiscarder(logRotator(numToKeepStr: '3'))
			disableConcurrentBuilds()
		}

		parameters{
			booleanParam defaultValue: false, description: 'Push a registry AWS', name: 'pushdeploy'
		}
		
		stages{
		
			stage('Checkout') {
				steps {
                echo '------------>Checkout desde Git Microservicio<------------'
                checkout([
	                	$class: 'GitSCM', 
	                	branches: [[name: '*/master']], 
	                	doGenerateSubmoduleConfigurations: false, 
	                	extensions: [], 
	                	gitTool: 'Git_Centos', 
	                	submoduleCfg: [], 
	                	userRemoteConfigs: [[
	                		credentialsId: 'GitHub_Screnhack', 
	                		url: 'https://github.com/Screnhack/consultoriaabogados'
	                		]]
                	])
				}
			}
		
		
			stage('Compile & Unit Tests') {
		      steps{
		        echo "------------>Unit Tests<------------"
		        sh 'gradle --b ./build.gradle clean compileJava'
		        sh 'gradle --b ./build.gradle test'
		
		      }
    		}
			
			stage('Sonar Analysis'){
				steps{
					echo '------------>Analisis de código estático<------------'
					 	withSonarQubeEnv('Sonar') {
                     	sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties"
                     }
				}
			}
			stage('Build') {
			      steps {
			        echo "------------>Build<------------"
			        //Construir sin tarea test que se ejecutó previamente
					sh 'gradle --b ./build.gradle build -x test'
			      }
			    }  
			  }
		
		post {
			failure {
				mail(to: 'andres.villamizar@ceiba.com.co',
				body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
				subject: "ERROR CI: ${env.JOB_NAME}")
			}
		}	
			
}