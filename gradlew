#!/bin/sh
# Gradle wrapper script

GRADLE_WRAPPER_VERSION=8.0.2
GRADLE_WRAPPER_JAR="gradle/wrapper/gradle-wrapper.jar"

if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
  echo "Gradle Wrapper JAR not found! Downloading..."
  mkdir -p gradle/wrapper
  curl -o "$GRADLE_WRAPPER_JAR" "https://services.gradle.org/distributions/gradle-$GRADLE_WRAPPER_VERSION-bin.zip"
fi

exec java -jar "$GRADLE_WRAPPER_JAR" "$@"
