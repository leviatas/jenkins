gitHubLibrary("jenkins")
pipeline {
  agent any

  stages {
    stage('Print Changes') {
      when {
        expression {
          return validateChanges()
        }
      }
      steps {
          script{
            sh "echo Hubo Cambios"
          }
      }
    }
    stage("Build") {
      steps {
        sh "chmod +x ./gradlew build"
      }
    }
    stage("Release") {
      when {
        branch "main"
        not { changeRequest() }
      }
      steps {
        sh "git tag -f release"
        gitPush(followTags: true, force: true)
      }
    }
  }

}
