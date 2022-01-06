def call() {
    //String name = Bar.loadName("foo")
    // echo "Hello, ${name}!"
    return true
}

// Get the list of changed files
List<String> getChangedFilesList(String folderName = "") {

    echo "${GIT_COMMIT}"

    changedFiles = sh(returnStdout: true, script: "git diff-tree --no-commit-id --name-only -r ${GIT_COMMIT}").trim()
    echo "Current changedFiles: ${changedFiles}"

    if (changedFiles.contains(folderName)){
        // echo "Contains folder ${folderName}? yes"
        return true;
    }else{
        // echo "Contains folder ${folderName}? no"
        return false;
    }
}
