Jenkinsfile (Declarative Pipeline)
pipeline {
    agent {
        any
    }
    stages {
        stage('准备') {
            steps {
                echo 'starting ......'
                git branch: 'master', credentialsId: 'c4401499-88c3-4488-928f-df0a24c3fb68', url: 'https://github.com/XinkTech/dataset-service.git'
            }

        }

        def mvnHome = tool 'M3'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
        stage('单元测试') {
            steps {
                echo 'Junit testing ......'
                sh 'mvn test'
            }
        }

        stage('构建') {
            steps {
                echo 'Compiling ......'
                step{
                    echo 'making imge ......'
                }
                step{
                    echo 'starting imge ......'
                }
            }
        }

        stage('测试') {
            steps {
                echo 'Testing ......'

            }
        }

        stage('发布') {
            steps {
                echo "Deploy imge!"
            }
        }
    }
}

