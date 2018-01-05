
# Spring

### 1. Overview
Spring is the most popular application development framework for enterprise Java. Spring targets to make J2EE development easier and promotes good programming practices by enable a POJO-based programming model. The core features of Spring framework:
* **Dependency Injection (DI)** -- The technology that Spring is identified with is Dependency Injection flavor of Inversion of Control. Inversion of Control (IoC) is the general concept and Dependency Injection is merely one concrete example of Inversion of Control. What is Dependency Injection exactly? Let's look at two words separately. *Dependency* is the association between two classes. For example, class A is dependent of class B. Now look at the second part *injection*. All this means is, class B will be injected to class A by the IoC.
* **Aspect Oriented Programming (AOP)** -- The common functions that span multiple points in an application are called **cross-cutting concerns**. These cross-cutting concerns are separate from the application's business logic. There are various good examples of aspects including logging, security, caching, etc. The key unit of modularity in OOP is class, whereas in AOP the key unit of modularity is aspect. DI helps to decouple application objects from each other, while AOP helps to decouple cross-cutiing concerns from the object they affect.


### 2. Spring Architecture
#### 2.1 Core Container
* **Core** provides the fundamental parts of the framework including the IoC and Dependency Injection features.
* **Bean** provides the BeanFactory which is a sophisticated implementation of the factory pattern.
* **Context** is a medium to access any objects defined and configured. The ApplicationContext is the focal point of the Context module.
* **SpEL** provides a powerful expression language for querying and manipulating an object graph at runtime.

#### 2.2 Data Access/Integration
* **JDBC** provides JDBC-abstraction layer to remove tedious JDBC related coding.
* **ORM** provides integration layers for popular object-relational mapping APIs like JPA, Hibernate, iBatis.
* **OXM** provides an abstraction layer for Object/XML Mapping.
* **JMS (Java Messaging Service)** provides features for producing and consuming messages. 
* **Transaction** supports programmatic and declarative transaction management for classes that implement special interfaces and for all your POJOs.

#### 2.3 Web
* **Web** provides basic web-oriented integration features such as multipart file uploading and the initialization of IoC container using Servlet listener and a web-oriented application context. 
* **Web-MVC** contains Spring's Model-View-Controller implementation for web applications.
* **Web-Socket** supports Websocket-based two way communication between client and server in a web application.
* **Web-Portlet** provides MVC implementation in Portlet environment.


#### 2.4 Others
* **AOP** provides aspect oriented programming implementation.
* **Aspects** provides integration with AspectJ which is a powerful and mature AOP framework.
* **Messaging** module provides support for STOMP as the WebSocket sub-protocol to use in applications. It also supports an annotation programming model for routing and processing STOMP messages from WebSocket clients.
* **Instrumentation** module provides class instrumentation support and class loader implementations to be used in certain application servers.
* **Test** module supports the testing of Spring components with JUnit or TestNG frameworks.


### 3. IoC Container
Spring Container is at the core of the framework. The container will create the objects, wire them together, configure them and manage their complete life cycle from creation til destruction. The Spring container uses DI to manage the components that make up the application. These objects are called Spring Beans.<br/>

The Spring container gets its instructions on what objects to instantiate, configure and assemble by reading the configuration metadata provided. The configuration metadata can be presented either by XML, annotations or Java code. The Spring Container makes use of POJO objects and configuration metadata to produce a fully configured and executable system or application.<br/>

Spring provides two distinct types of container:
* **BeanFactory Container**
* **ApplicationContext Container**


### 4. Bean Definition
The objects that forms the backbone of the application and that are managed by the IoC container are called Spring beans. A bean is an object that is instantiated, assembled and otherwise managed by a Spring IoC container. Beans are created with configuration metadata that we supply to the container. Bean definition contains the information called **configuration metadata** which is needed for the container to know:
* How to create a bean
* Bean life cycle details
* Bean's dependencies
The table below describes all properties that make up a bean definition.

| Properties | Description |
| ----- | ----- |
| class | This attribute is mandatory and specifies the bean class to be used to create a bean |
| name | This attribute specifies the bean identifier uniquely |
| scope | This attribute specifies the bean object |
| constructor-arg | This is used to inject the dependencies |
| properties | This is used to inject the dependency |
| autowiring mode | This is used to inject the dependencies |
| lazy-initialization mode | This tells the IoC container to create a bean instance at the first time it's requested |
| initialization method | A callback to be called after all properties on the bean have been set by the container |
| destruction method | A callback to be called after when the container contains the bean is destroyed |

There are 3 ways to provide the Spring Container the configuration metadata:
* XML based configuration file
* Java annotations
* Java code

### 5. Bean Scopes
When defining a bean we have an option to specify the scope of that bean. For example, to force the Spring Container to create a new bean instance each time one is needed we should declare the bean's scope is **prototype**. Or if we want the Spring Container return the same bean instance each time one is needed we should declare the bean's scope is **singleton**. Srping supports 5 following scopes.

| Scope | Description |
| --- | ---- |
| singleton | Single instance per Container (default scope) |
| prototype | Any number of object instances |
| request | New instance for each HTTP request. Only valid in the context of a web-aware Spring ApplicationContext |
| session | New instance for each HTTP session. Only valid in the context of a web-aware Spring ApplicationContext |
| global-session | New instance for a global HTTP session. Only valid in the context of a web-aware Spring ApplicationContext |

### 6. Bean Life Cycles
There are many activities that take place between the time of bean initialization and its destruction. But two most important life cycles are initialization and destruction.
* **Initialization callback** -- The *org.springframework.beans.factory.InitializingBean* interface specifies a single method ```void afterPropertiesSet() throws Exception;```
* **Destruction callback** -- The *org.springframework.beans.factory.DisposableBean* interface specifies a single method ```void destroy() throws Exception;```


### 7. Dependency Injection
| DI Type | Description |
| --- | ---- |
| Constructor-Based DI | Constructor-Based DI is accomplished when the container invokes a class constructor with a number of arguments, each representing a dependency on the other class |
| Setter-Based DI | Setter-Based DI is accomplished by the container calling the setter methods on your bean after invoking no-argument constructor or no-argument static factory method to instantiate the bean |


### 8. Injecting Inner Bean
**Inner beans** are the beans that are defined within the scope of other beans. Thus, the <bean/> element insides the <property/> or <constructor-arg> element is called an inner bean like the declaration below:
```
<?xml version = "1.0" encoding = "UTF-8"?>

<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id = "outerBean" class = "...">
      <property name = "target">
         <bean class = "..."/>
      </property>
   </bean>

</beans>
```
An inner bean does not require an id or a name; if specified the container does not use such a value as an idenitifier. Inner beans are always anonymous and they are always created with outer bean. It's impossible to inject inner bean into collaborating beans to access them independently.


### 9. Injecting Collection
Spring offer 4 types of collection configuration elements which are follows.

| Collection element | Description |
| -------- | ------ |
| list | This helps in injecting a list of values, allowing duplicates |
| set | This helps in injecting a set of values, not allowing duplicate |
| map | This helps in injecting collection of key-value pairs which can be any type |
| props | This helps in injecting collection of key-value pairs which both key and value are String |


### 10. Bean Auto-Wiring
Spring container can autowire the relationships between the collaborating beans without using <constructor-arg> and <property> elements, which helps cut down the amount of XML configuration.<br/>

Following are the modes of autowiring which can be used to instruct the Spring container to use autowiring for dependency injection. We use the *autowire* attribute of the <bean/> element to specify autowire mode for bean definition.

| Mode | Description |
| ------ | --------- |
| no | This is the default setting which mean no autowiring and you have to use explicit bean reference for wiring. |
| byName | Autowiring by propertiy name. Spring container looks at the properties of the bean and it tries to match and wire its properties with beans defined by the same names in configuration file. |
| byType | Autowiring by property datatype. The Spring container looks at the properites of the beans and it tries to match and wire its properties with beans has exactly same type defined in configuration file. If more than one such beans exists, a fatal exception will be thrown. |
| constructor | Similar to byType. But type applies to constructor arguments. |
| autodectect | Spring first tries to wire autowire by constructor, if it does not work, Spring tries to use autowire by byType. |

### 11. Annotation Based Configuration
Starting from Spring 2.5, it's possible to config dependency injection by using annotations. Annotations injection will be performed before XML. Thus, the latter configuration will overwrite the former one.<br/>

Annotation wiring is the the default. So, to use the annotation wiring we need to turn it on in Spring configuration file as follow.
```
<?xml version = "1.0" encoding = "UTF-8"?>

<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xmlns:context = "http://www.springframework.org/schema/context"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
   http://www.springframework.org/schema/context
   http://www.springframework.org/schema/context/spring-context-3.0.xsd">

   <context:annotation-config/>
   <!-- bean definitions go here -->

</beans>
```

Following are some of the most important annotations.

| Annotation | Description |
| --- | ------ |
| **@Required** | This annotation applies to bean property setter methods. |
| **@Autowired** | This annotation applies to bean property setter methods, non-setter methods, constructors and properties. |
| **Qualifier** | This annotation is used along with @Autowire to remove confusion by specifying which exact bean can be wired. |


### 12. Java Based Configuration
#### @Configuration and @Bean Annotations
Annotating a class with **@Configuration** indicates that the Spring container can use that class as a source of bean definitions. The **@Bean** annotation tell Spring that a method annotated with @Bean will return an object that should be registered as a bean in the Spring application context. The example as follow.

```
import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfig {
   @Bean 
   public HelloWorld helloWorld(){
      return new HelloWorld();
   }
}
```

#### Injecting Bean Dependencies
```
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
   @Bean
   public Foo foo() {
      return new Foo(bar());
   }
   @Bean
   public Bar bar() {
      return new Bar();
   }
}
```

#### Life Cycle Callbacks
The @Bean annotation supports specifying the initialization and desctruction callback methods.
```
public class Foo {
   public void init() {
      // initialization logic
   }
   public void cleanup() {
      // destruction logic
   }
}
@Configuration
public class AppConfig {
   @Bean(initMethod = "init", destroyMethod = "cleanup" )
   public Foo foo() {
      return new Foo();
   }
}
```

#### Specifying Bean Scope
```
Configuration
public class AppConfig {
   @Bean
   @Scope("prototype")
   public Foo foo() {
      return new Foo();
   }
}
```


### 15. AOP with Spring 
