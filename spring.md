
# Spring

### 1. Overview
Spring is the most popular application development framework for enterprise Java. Spring targets to make J2EE development easier and promotes good programming practices by enable a POJO-based programming model. The core features of Spring framework:
* **Dependency Injection (DI)** -- The technology that Spring is identified with is Dependency Injection flavor of Inversion of Control. Inversion of Control (IoC) is the general concept and Dependency Injection is merely one concrete example of Inversion of Control. What is Dependency Injection exactly? Let's look at two words separately. *Dependency* is the association between two classes. For example, class A is dependent of class B. Now look at the second part *injection*. All this means is, class B will be injected to class A by the IoC.
* **Aspect Oriented Programming (AOP)** -- The common functions that span multiple points in a application are called **cross-cutting concerns**. These cross-cutting concerns are separate from the application's business logic. There are various good examples of aspects including logging, security, caching, etc. The key unit of modularity in OOP is class, whereas in AOP the key unit of modularity is aspect. DI helps to decouple application objects from each other, while AOP helps to decouple cross-cutiing concerns from the object they affect.


### 2. Spring Architecture
#### 2.1 Core Container
* **Core** provides the fundamental parts of the framework including the IoC and Dependency Injection features.
* **Bean** provides the BeanFactory which is a sophisticated implementation of the factory pattern.
* **Context** is a medium to access any objects defined and configured. The ApplicationContext is the focal point of the Context module.
* **SpEL** provides a powerful expression language for querying and manipulating an object graph at runtime.

#### 2.2 Data Access/Integration

#### 2.3 Web

#### 2.4 Others

### 3. IoC Container
Spring container is at the core of the framework. The container will create the objects, wire them together, configure them and manage their complete life cycle from creation til destruction. The Spring container uses DI to manage the components that make up the application. These objects are called Spring Beans.<br/>

The Spring container gets its instructions on what objects to instantiate, configure and assemble by reading the configuration metadata provided. The configuration metadata can be presented either by XML, annotations or Java code. The Spring container makes use of POJO objects and configuration metadata to produce a fully configured and executable system or application.<br/>

Spring provides two distinct types of container:
* **BeanFactory Container**
* **ApplicationContext Container**


### 4. Bean Definition
The objects that forms the backbone of the application and that are managed by the IoC container are called Spring beans. A bean is an object that is instantiated, assembled and otherwise managed by a Spring IoC container. Beans are created with configuration metadata that we supply to the container. 


### 5. Bean Scopes



### 6. Bean Life Cycles


### 9. Bean Post Processor
