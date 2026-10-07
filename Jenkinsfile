pipeline {

    agent any

    tools {
        
        maven 'M3'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                echo 'Cleaning previous Maven build...'
                bat 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling Java source code...'
                bat 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Maven tests...'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Creating Maven JAR...'
                bat 'mvn package -DskipTests'
            }
        }

    }

    post {

        success {
            echo '======================================'
            echo 'BUILD SUCCESS'
            echo 'PizzaHub Maven project built successfully!'
            echo '======================================'
        }

        failure {
            echo '======================================'
            echo 'BUILD FAILED'
            echo 'Check the Jenkins console output.'
            echo '======================================'
        }

        always {
            echo 'Jenkins pipeline execution completed.'
        }
    }
}
