def call() {
    //String name = Bar.loadName("foo")
    // echo "Hello, ${name}!"
    return true
}

// Get the list of changed files
@NonCPS
List<String> getChangedFilesList() {

    echo "${GIT_COMMIT}"

    changedFiles = "git diff-tree --no-commit-id --name-only -r ${GIT_COMMIT}".execute().text
    echo "Current changedFiles: ${changedFiles}"
    
    // for (changeLogSet in currentBuild.changeSets) { 
    //     for (entry in changeLogSet.getItems()) { // for each commit in the detected changes
    //         for (file in entry.getAffectedFiles()) {
    //             changedFiles.add(file.getPath()) // add changed file to list
    //         }
    //     }
    // }

    return changedFiles
}
