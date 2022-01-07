def call(String folderName = "") {
    // Validate that GIT_COMMIT is set
    if (env.GIT_COMMIT == null) {
        // Set GIT_COMMIT
        env.GIT_COMMIT = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
    }    
    
    echo "${GIT_COMMIT}"

    changedFiles = sh(returnStdout: true, script: "git diff-tree --no-commit-id --name-only -r ${GIT_COMMIT}").trim()
    // echo "Current changedFiles: ${changedFiles}"

    if (changedFiles.contains(folderName)){
        // echo "Contains folder ${folderName}? yes"
        return true;
    }else{
        // echo "Contains folder ${folderName}? no"
        return false;
    }
}

// // Get the list of changed files
// List<String> getChangedFilesList(String folderName = "") {

    
// }
