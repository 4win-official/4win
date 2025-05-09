@echo off
set GRADLE_WRAPPER_VERSION=8.0.2
set GRADLE_WRAPPER_JAR=gradle\wrapper\gradle-wrapper.jar

if not exist "%GRADLE_WRAPPER_JAR%" (
  echo Gradle Wrapper JAR not found! Downloading...
  mkdir gradle\wrapper
  curl -o "%GRADLE_WRAPPER_JAR%" "https://services.gradle.org/distributions/gradle-%GRADLE_WRAPPER_VERSION%-bin.zip"
)

java -jar "%GRADLE_WRAPPER_JAR%" %*
