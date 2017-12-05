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
        |
        |_______ pom.xml
    

* **src** is the root directory for source code and test code.
* **target** is the folder that contains the results of the build process (jar or war file).

### Project Dependencies
* The Java ecosystem is very HUGE. Today we have ton ton of Java open source libs out there. Almost Java business projects re-use those libraries, so we need a way to manage those dependencies.
* Maven provides built-in dependency management.
    ```
    <project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

        <groupId>com.tamco</groupId>
        <artifactId>java-gateway</artifactId>
        <version>1.0.0</version>

        <dependencies>
            <dependency>
              <groupId>org.jsoup</groupId>
              <artifactId>jsoup</artifactId>
              <version>1.7.1</version>
            </dependency>
        </dependencies>
    </project>
    ```

### Maven Repositories
Maven has three types of repository:
* **Local repository** is the directory (user-home/.m2) on developer's machine. This contains all dependency downloads. Your own project can be built and installed in local repository by running the command **mvn install**.
* **Central repository** is the repository provided by Maven community. By default, Maven looks in this repository to download any dependencies that has not existed on local repository yet.
* **Remote repository** is a repository on a web server from which Maven can download dependencies, just like the central repository. A remote repository can be located anywhere on the internet, or inside a local network.



### Maven Build Liffecycles, Phases and Goals
* When Maven builds a project it follows a Build Lifecycle. A Build Lifecycle is divided into Build Phases and Build Phases are divided in to Build Goals.
Maven has 3 built-in Build Lifecycles:
    * default
    * clean
    * site
* Each of these Build Lifecycles takes care of different aspect of building software project. The **default** life cycle handles everything related to compiling and packaging your project. The **clean** life cycle handles everyting related to removing temporary files from output directory. The **site** life cycle handles everything related to generating document.
* Each life cycle is divided into sequence of build phases. And build phases are divided into build goals. So, the total build process is the sequence of build life cycle(s), build phases and goals. You can execute a whole build life cycle (like *clean* and *site*), or a build phase (like *install*), or a goal. Note: you cannot execute the *default* life cycle directly, you have to specify the phase in that life cycle.
* The table below describes some most commonly used phases:

    | Build Phase | Description |
    | --- | --- |
    | validate | Validates that the project is correct and all necessary information is available. This also makes sure that the dependencies are downloaded. |
    | compile | Compiles the source code of the project. |
    | test | Run tests againts the compiles source code using the suitable unit testing framework. |
    | package | Packs the compiles source code in its distributable format, such as JAR or WAR. |
    | install | Installs the package to local repository, for use as a dependency in other projects locally. |
    | deploy | Copy the final package to a remote repository to share with other developers and projects. |
    
### Maven Command Structure
A Maven command consists of 2 elements:
* mvn
* One or more build life cycles, build phases or build goals

For examlple, **mvn clean package** will execute all build phases of clean life cycle ang then execute the build phase package of the default life cycle.

### Maven Build Profiles

### Maven Plugins
