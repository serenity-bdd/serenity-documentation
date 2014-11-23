#!/bin/bash 
function junit-quick-start {
	echo "Building junit-quick-start"
	cd junit-quick-start && ./gradlew clean build
}

junit-quick-start
