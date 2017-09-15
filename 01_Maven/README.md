# Maven

This example covers:
+ Creating a MVN Project


### To Generate

```
$ mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1
```


### Configuration Properties

```
groupId: edu.hes.e57.demo
artifactId: demo
version: : 1.0-SNAPSHOT                  
package: edu.hes.e57.demo
```


### Console Output

```
$ mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> maven-archetype-plugin:3.0.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO] 
[INFO] <<< maven-archetype-plugin:3.0.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO] 
[INFO] --- maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Interactive mode
[INFO] Archetype repository not defined. Using the one from [org.apache.maven.archetypes:maven-archetype-quickstart:1.1] found in catalog remote
Define value for property 'groupId': edu.hes.e57.demo
Define value for property 'artifactId': demo
Define value for property 'version' 1.0-SNAPSHOT: : 1.0-SNAPSHOT                  
Define value for property 'package' edu.hes.e57.demo: : jar
Confirm properties configuration:
groupId: edu.hes.e57.demo
artifactId: demo
version: 1.0-SNAPSHOT
package: jar
 Y: : y
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.1
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: basedir, Value: /workspace
[INFO] Parameter: package, Value: jar
[INFO] Parameter: groupId, Value: edu.hes.e57.demo
[INFO] Parameter: artifactId, Value: demo
[INFO] Parameter: packageName, Value: jar
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] project created from Old (1.x) Archetype in dir: /workspace/demo
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 02:39 min
[INFO] Finished at: 2017-09-14T06:52:12-04:00
[INFO] Final Memory: 14M/127M
[INFO] ------------------------------------------------------------------------
```
