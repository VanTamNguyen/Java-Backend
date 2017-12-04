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

### Maven Directory Structure

### Project Dependencies

### Maven Repositories

### Maven Build Liffecycles, Phases and Goals

### Maven Build Profiles

### Maven Plugins
