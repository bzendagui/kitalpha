//  We are using a custom pod template to increase the memory setting. This is required by rcptt execution.
//  The pod template usage doesn't allow anymore the usage of declarative pipeline keyword and function. for examples When/post keywords or changeRequest() functions 

podTemplate(
  label: "migration-custom",
  cloud: "kubernetes", 
  inheritFrom: "migration-agent",
  containers: [
    containerTemplate(
        name: "jnlp", 
        image: "eclipsecbijenkins/migration-fat-agent:3.29", 
        resourceRequestMemory: "6144Mi", 
        resourceLimitMemory: "6144Mi"
    )
  ]) {
    node("migration-custom") {
    stage('Package & test Kitalpha') {
	  	wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                git 'https://github.com/eclipse/kitalpha.git'
              	sh '''
              		env
              	    export JAVA_HOME=/opt/tools/java/oracle/jdk-8/latest
              	    /opt/tools/apache-maven/latest/bin/mvn -Dmaven.test.failure.ignore=true -Dtycho.localArtifacts=ignore clean verify -B -e -f releng/plugins/org.polarsys.kitalpha.releng.parent/pom.xml
          	    '''
			   archiveArtifacts artifacts: '**/*.log, **/*.layout, releng/plugins/org.polarsys.kitalpha.releng.samplecomponent.updatesite/target/repository/**, releng/plugins/org.polarsys.kitalpha.releng.runtime.core.updatesite/target/repository/**,releng/plugins/org.polarsys.kitalpha.releng.runtime.updatesite/target/repository/**,releng/plugins/org.polarsys.kitalpha.releng.sdk.updatesite/target/repository/**, releng/plugins/org.polarsys.kitalpha.releng.sdk.product/target/products/*.zip'
		       junit '**/target/surefire-reports/*.xml'
	    }
    }
    stage('SonarQube analysis') { 
    	withSonarQubeEnv('Sonar') {
			//-Dsonar.auth.token=${SONAR_AUTH_TOKEN} -Dsonar.login=${SONAR_LOGIN} -Dsonar.password=${SONAR_PASSWORD} -Dsonar.jdbc.url=${SONAR_JDBC_URL} -Dsonar.jdbc.username=${SONAR_JDBC_USERNAME} -Dsonar.jdbc.password=${SONAR_JDBC_PASSWORD}"
          sh 'mvn $SONAR_MAVEN_GOAL -PKitalphaSonar ' + 
          '-f all/pom.xml ' +
          '-Dsonar.host.url=https://sonar.eclipse.org/ '
          '-Dsonar.projectKey=org.polarsys:org.polarsys.kitalpha ' +
          '-Dsonar.login=$SONAR_UN ' +
          '-Dsonar.password=$SONAR_PW '
        }
    }
    stage('Deploy') {
          sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
            sh '''
     	    if [ -z "$CHANGE_TARGET" ]
					then
						# if the variable is empty, then a PR has been built.
						echo "deploy update sites"
						DEST_DIR=/home/data/httpd/download.eclipse.org/kitalpha/updates/nightly
						VERSION=master
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}/component/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}/runtime/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}/runtimecore/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}/sdk/${VERSION}
						
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}/component/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}/runtime/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}/runtimecore/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}/sdk/${VERSION}
						
						scp -r releng/plugins/org.polarsys.kitalpha.releng.samplecomponent.updatesite/target/repository/* genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}/component/${VERSION}
						scp -r releng/plugins/org.polarsys.kitalpha.releng.runtime.updatesite/target/repository/* genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}/runtime/${VERSION}
						scp -r releng/plugins/org.polarsys.kitalpha.releng.runtime.core.updatesite/target/repository/* genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}/runtimecore/${VERSION}
						scp -r releng/plugins/org.polarsys.kitalpha.releng.sdk.updatesite/target/repository/* genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}/sdk/${VERSION}
						
						echo "deploy product"
						DEST_DIR=/home/data/httpd/download.eclipse.org/kitalpha/products/nightly/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}
						scp -r releng/plugins/org.polarsys.kitalpha.releng.sdk.product/target/products/*.zip genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}
					fi
            '''
        }
    }
  }
}