# Maven

### What is Maven?
* **Maven** is a build tool mostly used in Java projects. By build tool it means making everything related to building the software project automatically. But maven also provides many functions like *documentation*, *dependencies management*, *release*...

### POM (Project Object Model)
* **POM** is an xml file that describes the resources of the project. This includes where is source code, test code, what external library it has. POM file describes *what* to build. Each project has a POM file (pom.xml) located in the root directory of the project.
* This is an mininal POM file
    ```
    <project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>3.0.0</modelVersion>

        <groupId>com.tamco</groupId>
        <artifactId>java-gateway</artifactId>
        <version>1.0.0</version>
    </project>
    ```
* **groupId** is the unique ID for a project. Most often we use Java root package name of the project as the groupId. But it does not have to be the Java package name and does not need to use dot notation.
* **artifactId** is the name of the project.
* **version** is the version of the project.

### Maven Directory Structure
    root|
        |_______ src|
        |           |_______ main|
        |           |            |_______ java
        |           |            |_______ resources
        |           |            |_______ webapp
        |           |
        |           |_______ test|
        |                        |_______ java
        |                        |_______ resources
        |
        |_______ target
        
* **src** is the root directory for source code and test code.
* **target** is the folder that contains the results of the build process (jar or war file).

### Project Dependencies

### Maven Repositories

### Maven Build Liffecycles, Phases and Goals

### Maven Build Profiles

### Maven Plugins
