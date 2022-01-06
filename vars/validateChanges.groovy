def call() {
    //String name = Bar.loadName("foo")
    // echo "Hello, ${name}!"
    return true
}

// Get the list of changed files
String getChangedFilesList() {

    changedFiles = []
    for (changeLogSet in currentBuild.changeSets) { 
        for (entry in changeLogSet.getItems()) { // for each commit in the detected changes
            for (file in entry.getAffectedFiles()) {
                changedFiles.add(file.getPath()) // add changed file to list
            }
        }
    }

    echo "${changedFiles}"

    return changedFiles

}
