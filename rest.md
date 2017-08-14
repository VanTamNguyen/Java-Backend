# REST


### 1. Definition
* The mistake that's often made when approaching REST is
 to think of it as *web services with URLs*
* REST is resource-oriented, emphasizing the things and
nouns that describe the application
* REST (REpresentational State Transfer)
    * **Representational**: REST resources can be represented in any virtually form,
    including XML, JSON or even HTML, whatever forms best suits
    the consumers of those resources
    * **State**: When working with REST, we are more concerned 
    with state of resources than with the actions we take against
    resources
    * **Transfer**: REST involves transferring resource data,
     in some representational form, from one application to another
* Conclusion: REST is about transfer the state of resources, in whatever
form is most appropriate, from a server to client (or vice versa)

### 2. Six constraints
* **Uniform interface**
    * Resource indentification in request
    * Resource manipulation through representation
    * Sefl-descriptive messages
    * Hypermedia as the engine of application state (HATEOAS)
* **Client - server**
    * Meaning client application and server application MUST be able to evolve separately without any dependency on each other (loose coupling). Client should know only resource URI and that's all.
    * Servers and clients may also be replaced and developed independently, as long as the interface between them is not altered.
* **Stateless**
    * Make all client-server interaction stateless. Meaning server will not store anything about latest http request client made. It will treat each and every requests as new. No session. No history.
    * If client application need to be a stateful application for end user, where user logs in once and do other authorized operations thereafter, then each request from the client should contain all the information necessary to service the request – including authentication and authorization details.
    * No client context shall be stored on the server between requests. Client should be reponsible for managing state of the application.
* **Cacheable**
    * In REST, caching be applied on resources when applicable and then these resources MUST declare themselves cacheable. Caching can be implemented on client or server side.
* **Layered system**
    * A client cannot ordinarily tell whether it is connected directly to the end server, or to an intermediary along the way.
* **Code on demand (optional)**
