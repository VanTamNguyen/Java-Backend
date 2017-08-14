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
* Uniform interface
* Client - server
    * Meaning client application and server application MUST be able to evolve separately without any dependency on each other (loose coupling). Client should know only resource URI and that's all.
    * Servers and clients may also be replaced and developed independently, as long as the interface between them is not altered.
* Stateless
* Cacheable
* Layered system
* Code on demand
