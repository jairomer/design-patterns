# When to use the observer pattern 

[Observer pattern](https://youtu.be/wiQdrH2YpT4?list=PLF206E906175C7E07)

The observer pattern is a software design pattern in which an object, called the subject, maintains 
a list of its dependants, called observers, and notifies them automatically of any state changes, 
usually by calling one of their methods.  

When you need many objects to receive an update when another object changes. 

*Examples*
- Stock market with thousands of stocks needs to send updates to objects representing individual stocks. 
- The subject (publisher) sends many stocks to the observers. 
- The observers (subscribers) takes the ones they want and use them. 

**Benefits**
- Loose coupling as the publisher doesn't need to know anything about the subscribers. 

**Negatives**
- The publisher may send updates that do not matter to the observer (subscribers). 