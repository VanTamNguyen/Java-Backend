# Servlet

### 1. What is Servlet
To understand servlet we need understand Web Server and CGI (Common Gateway Interface)

* **Web Server** is a (system of) software running on a server listen on default port 80 (maybe other port) to handle http requests and respond http responses to client.

* **CGI** offers a standard protocol for web servers to execute programs that execute like Console applications (also called Command-line interface programs) running on a server that generates web pages dynamically. Such programs are known as CGI scripts or simply as CGIs. As the name reveals, CGI acts as "gateway" between Web Server and the programs that generate dynamic web pages. When a http request comes to web server, it will parses request and pass parameters to CGI to trigger the program that generates response. <br/><br/>
![cgi](images/cgi.png)

* **CGI's drawbacks**
    * For each requests it starts a new process (CGI script) and Web server is limited to start process
    * If the number of clients increases it takes more time to response
    * Platform dependent

* **Servlet** is a Java program that extends capabilities of a server. Although servlets can respond to any type of requests [they most commonly implement application hosted on Web server](https://en.wikipedia.org/wiki/Java_servlet) (HTTP Servlet). As I understand it's a replacement of CGI. Servlet's functionality is similar to CGI that is generating response for client. But servlet does not run on a separate process, it runs under Web server's process.<br/>
![servlet](images/java-servlet.png)

* **Advantages of Servlet**
    * Better performance because it starts a thread for each requests instead of process
    * Portability because it's Java program

### 2. Some concepts
* **Servlet Container**
* **Servlet Context**
* **Tomcat**
* **Web Application Structure on Tomcat**

### 3. Servlet Life Cycle

### 4. ServletRequest

### 5. ServletResponse

### 6. ServletContext

### 7. Filter

### 8. Session Management
