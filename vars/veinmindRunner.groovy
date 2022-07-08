#!/usr/bin/env groovy

def scan(String imageRef, int exitCode){
    scan(imageRef, "scan-host", "report.json", exitCode)
}

def scan(String imageRef, String scanAction = "scan-host", String outPut = "report.json", int exitCode = 0) {
    // check
    if (scanAction == null){
        scanAction = "scan-host"
    }
    if (outPut == null){
        outPut = "report.json"
    }
    if (exitCode == null){
        exitCode = 0
    }
    sh "docker run --rm --mount \'type=bind,source=/,target=/host,readonly\' -v /var/run/docker.sock:/var/run/docker.sock veinmind/veinmind-runner ${scanAction} ${imageRef} -o ${outPut} -e ${exitCode}"
}