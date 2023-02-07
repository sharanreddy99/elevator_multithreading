mvn archetype:generate -DgroupId=com.sharankonda.elevatorapp -DartifactId=elevatorapp -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn package
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App