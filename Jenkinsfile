pipeline {
    agent none
    stages {
        stage('Clone Code') {
            agent {
                label 'master'
            }
            steps {
                echo "1.Git Clone Code"
                sh 'curl "http://p2.nju.edu.cn/portal_io/login?username=usm&password=pwd"'
                git branch: "main", url: "https://github.com/chillcharlie357/CloudNativeFinal.git"
            }
        }
        stage('Test'){
            agent {
                label 'master'
            }
            steps {
                sh 'gradle test'
            }
        }
        stage('Image Build') {
            agent {
                label 'master'
            }
            steps {
                echo "2.Image Build Stage"
                sh 'docker build -f Dockerfile -t msg:${BUILD_ID} . '
                sh 'docker tag msg:${BUILD_ID} harbor.edu.cn/nju09/msg:${BUILD_ID}'
            }
        }
        stage('Push') {
            agent {
                label 'master'
            }
            steps {
                echo "3.Push Docker Image Stage"
                sh "docker login --username=nju09 harbor.edu.cn -p nju092023"
                sh "docker push harbor.edu.cn/nju09/msg:${BUILD_ID}"
            }
        }
    }
    post {
        always {
            junit 'build/reports/**/*.html'
        }
    }
}


node('slave') {
    container('jnlp-kubectl') {

        stage('Clone YAML') {
            echo "4. Git Clone YAML To Slave"
            sh 'curl "http://p2.nju.edu.cn/portal_io/login?username=usm&password=pwd"'
            git branch: "main", url: "https://github.com/chillcharlie357/CloudNativeFinal.git"
        }

        stage('YAML') {
            echo "5. Change YAML File Stage"
            sh 'sed -i "s/\${VERSION}/${BUILD_ID}/g" ./Jenkins/msg_deployment.yaml '
        }

        stage('Deploy') {
            echo "7. Deploy To K8s Stage"
            sh 'kubectl apply -f ./Jenkins/msg_deployment.yaml'
        }
    }
}
