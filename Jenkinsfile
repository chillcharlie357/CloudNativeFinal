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
        stage('Gradle Build') {
            agent {
                docker {
                    image 'gradle:latest'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                echo "2.Gradle Build Stage"
                sh 'gradle clean build -x test'
            }
        }
        stage('Image Build') {
            agent {
                label 'master'
            }
            steps {
                echo "3.Image Build Stage"
                sh 'docker build -f Dockerfile -t msg:${BUILD_ID} . '
                sh 'docker tag msg:${BUILD_ID} harbor.edu.cn/nju09/msg:${BUILD_ID}'
            }
        }
        stage('Push') {
            agent {
                label 'master'
            }
            steps {
                echo "4.Push Docker Image Stage"
                sh "docker login --username=nju09 harbor.edu.cn -p nju092023"
                sh "docker push harbor.edu.cn/nju09/msg:${BUILD_ID}"
            }
        }
    }
}


node('slave') {
    container('jnlp-kubectl') {

        stage('Clone YAML') {
            echo "5. Git Clone YAML To Slave"
            git url: "https://github.com/chillcharlie357/CloudNativeFinal.git"
        }

        stage('YAML') {
            echo "6. Change YAML File Stage"
//        sh 'sed -i "s#{VERSION}#${BUILD_ID}#g" ./jenkins/scripts/prometheus-test-demo.yaml'
        }

        stage('Deploy') {
            echo "7. Deploy To K8s Stage"
//        sh 'kubectl apply -f ./jenkins/scripts/prometheus-test-demo.yaml'
        }
    }
}
