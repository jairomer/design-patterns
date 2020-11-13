# When to use the strategy pattern

When you want to define a class that will have one behavior that is similar to other behaviours in a list. 

**Flying strategies**
- Not flying.
- Fly with wings.
- Fly super fast. 

This pattern is useful to set one of several behaviours dynamically. 

**Advantages**
- Often reduces long lists of conditionals. 
- Avoids duplicated code. 
- Keeps class changes from forcing other class changes. (Avoids shotgun editing). 
- Can hide complicated code from the user. 

**Disadvantages**
- Increases the number of objects and classes.