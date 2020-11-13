# Compilation of design patterns. 

An ongoing work in progress for the study and understanding of software desing patterns.

**Design patterns are the best formalized practices a programmer can use to solve common problems when designing an application or system.**


## Behaviour 

**Define patterns relating manners of communication between classes and objects.**

##### Command: Encapsulates a request as a type of object.
 + Build a container of an action that implements an interface. 
 + Pass this container to an Invoker that uses that interface to execute the action.
 + Build a container to your action that contains a reference to the receiver of that action and then execute it on the invoker. 

##### Interpreter: A way of externalizing the problem to solve in another programming language like regex or a compiler.  

##### Iterator: Provides an unified abstract way to iterate through a collection of objects. 
 + A client uses an unified interface to iterate through a collection, which is then implemented by a concrete class. 
 + This concrete implementation uses the concrete container that implements a container interface. 
 + A given user then uses both interfaces to create the container and iterate over it. 

##### Mediator: An object encapsulates relations between two objects to keep them mutually independent. 
 + Intermediary or controller. 
 + Used in action/reaction behaviour that tends to create highly coupled systems. 
 + A Mediator interface is used by the objects tasked with the notifications on the system. 
 + A concrete mediator implements this interface to handle a particular kind of notification and send it to the required object(s).

##### Memento: A way of storing internal details of objects without exposing them to the external world. 
 + Many posibilities, can be used to implement 'undo' functionalities. 
 + Two interfaces are defined, the Originator, that encapsulates a state, and a Memento which restores it. 
 + The concrete classes implement two functionalities: 
  * Store a state. 
  * Restore a state. 
 + The collection of mementos or history is stored in a stack on some kind of caretaker, which implements the undo() operation.   

##### Observer: used to notify other components about some event that happened. 
 + Publisher-Subscriber, Listener...  
 + Example: Chat room. 
 + Used when we have a list of subscribers. 
 + It is more dynamic than chain-of-command and is easy to add or remove listeners. 
 + However, it is not easily ordered, while chain-of-command is. 
 + A subscriber interface has an `update(event)` that is executed to update its state. 
 + A subscriber reference is added or removed from the list of a publisher class, which is also tasked with notifying them.  

##### Responsibility chain: A request is passed down to a processor that decides by itself what kind of handler to process it.
 + Command chain.
 + The request is passed to an _abstract handler_ that will evaluate if it can process the request. 
 + If it cannot, then the request is passed down to the _next handler_, which is initializated to handle the request. 
 + Repeat until the request is handled or we run out of handlers.
 + The request can also be dropped at any point if necessary. 
 + Examples: User generated events, network packets.
  
##### State: Used when we want to expand the Strategy pattern to build the application or task as a finite state machine.
 + The state context object contains a kind of State interface, which is implemented by concrete states with an `execute()` method. 
 + This state context then switches the state and executes the action depending of the conditions of the finite state machine. 

##### Strategy: Means of defining a family of algorithms that solve a given problem in an interchangeable way. 
 + Example: Route finding on a map. 
 + We achieve this implementing an interface Strategy with a method `execute()`. 
 + Each of the concrete classes implement a different strategy. 
 + Finally, a client class uses this interface to receive a strategy on the constructor and execute the action.   

##### Template Method: Provides a template or skeleton to extend an algorithm without modifying it.
 + Examples: Parsers, loaders and persisters. 
 + Some tasks repeat steps or subprocesses. 
 + These steps are implemented on a template or base and overrided/specialized on the derived classes.    

##### Visitor: Used to separate models from logic, in order to reduce coupling. 
 + We start with an interface called 'Component', which accepts visitors with `accept(Visitor)`. 
 + Accepting a visitor means giving it access to the internal state of a component. 
 + Then we define a visitor interface that defines a method for any concrete component that can be visited. 
 + An implementation of this interface will contain all the logic to handle any given concrete component, which are usually model classes. 
 + This implementation is then used by a visitor client, which contains a list of concrete component instances and an instance of a Visitor, which can be used to operate over the concrete components. 
 + We then use polymorphism to execute the specific logic for each kind of concrete component. 
 + New concrete components can be added by simpling extending the Visitor interface and implementing the logic in the concrete visitor. 

## Creation 

**Responsible for efficient object creation mechanisms to increase the flexibility and reuse of the existing code or resources.**

##### Abstract Factory: Enables the production of families of related objects without specifying their concrete classes. 
 + KIT 
 + The client does not know or cares which kind of concrete class it is given. 
 + Example: Create a document, which can be a letter, a resume, etc. 
 + Used to interchange different implementations of an interface or abstract class without modifying the client code. 

##### Builder + Director: Separates build process from representation. When creation is complex, similar and _result objects_ cannot have a common superclass.
 + A director, with a reference to a builder, will have a construct method with a default implementation of the tasks to execute by the builder. 
 + This builder is implemented by a concrete builder that will store a reference of the "thing built". 
 + Each of the concrete builders have their own getter to access the created "thing", thus avoiding a common root, base or interface. 
 + This is useful to separate the creation algorithm from the object to be created. 
  - Director implements the algorithm. 
  - Builder contains the datastructure. 

##### Factory Method: Provides an interface for creating objects in a superclass, while allowing subclasses to alter the type of objects that will be created.   
 + Virtual Constructor
 + Given a set of parameters, generate a type or another from a hierarchy with an interface or abstract class at the root. 

##### Prototype: Produces new objects by copying (cloning) existing ones without compromising their internals.
 + Clone or Virtual Constructor
 + Used to: 
  * Avoid subclasses of an object creator in the client application.
  * Avoid the cost of creating a new object in the standard way when it is expensive.
 + Example: When a cell splits, two instances/clones of that cell are created.  
 + To implement it, derived classes must implement a common interface with a `clone()` method, which will return an exact copy of the instance. 

##### Singleton: Only guarantees one instance of a particular class to be created during the lifetime of a system and single global access to it.
 + _Often an antipattern because that guarantee is complicated to implement and also breaks encapsulation._
 + Example: Logger, Database Access Object.
 + Constructor is private and access is regulated by a single method called "getInstance()" that makes the first initialization and then returns a reference to it.

## Structure

**Responsible for building simple and efficient class hierarchies and relations between different classes and objects.**

##### Adapter: Adapt the interface of a class to work with another interface.  
 + Wrapper
 + Several ways to do it, inheritance or composition. (Prefer composition)
 + An adapter will implement the required interface, and use the class adapted. 
  
##### Bridge: Used to separate the implementation from the abstraction of a class. 
 + Body or handle.   
 + An application might be composed of several layers.
 + A layer will use an abstraction of another layer, which contains a reference to an interface that implements this layer. 
 + This interface is finally implemented by concrete classes.
 + The client abstraction is then implemented using this interface on a concrete implementation.
 + This way we can have several implementations of a service using different kidns of layers.   

##### Composite: Used when we have a tree-like data structure and we want to organize them in terms of leafs and parents. 
 + To implement it we have a common interface, that is implemented both by the leaves and the parents. 
 + This interface defines the operations that must be executed at the leaves. 
 + On the parent implementation, we have a list of children to which work is delegated on each of the methods of the interface.   

##### Decorator: Used to extend existing clases with new functionality without inheritance.   
 + Very similar to composite. 
 + A common interface providing a set of methods is given with the implementation we want to extend. 
 + To extend it, we create a new implementation of the interface called _Decorator_.
 + This implementation contains a reference to an instance of the extended class and uses its functionality within its own implemented interface. 
 + These Decorators can then be derived from and nested within other decorators for additional extensibility.  

##### Facade: Create a class that defines methods for complex, multistep actions to hide the complexity of a backend. 
 + **Careful** it is easy to generate a highly coupled class. Divide and delegate responsibilites as possible.    

##### Flyweight: Used when we have a lot of common information that is shared among many objects, like images in a videogame.  
 + Cache 
 + These cached values are called "unique states". 
 + The price to pay for this pattern is the dereferencing of these objects into the cached object. 
 + Access to these cached objects is regulated through a Flyweight<item>Factory that contains a map of objects and a get() method to access the cached instances.
 + We also have a class called Flyweight that obtains such cached item and regulates access to it. 

##### Proxy: A wrapper around a method on a different object. 
 + Examples: log actions, control access, lazy loading, getting remote data, cache results...
 + The only thing required is a common interface that is both implemented by the proxy and the proxied class. 
