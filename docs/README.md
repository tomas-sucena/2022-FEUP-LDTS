# project-l08gr02 - ZELDA
project-l08gr02 created by GitHub Classroom

> Join Link as he explores the unoptimized terminal of Lanterna

After saving Hyrule once again, Link decides to take a well-earned nap. However, he is cursed in his sleep by a furious programmer that could not beat his last game. When he wakes up from his slumber, our hero finds himself in a treacherous Lanterna terminal. Embark on a brand new adventure and help Link escape the evil Exceptions and Null Pointers!

This project was developed by Andreia Silva (up202108769@up.pt), Gonçalo Nadais de Pinho (up202108672@up.pt) and Tomás Sucena Lopes (up202108701@up.pt) for LDTS 2022⁄23.

-----
### UML Class Diagram

The following UML diagram represents how the various game classes interact with each other:

![UML Class diagram](uml.png)

-----
### IMPLEMENTED FEATURES

- **Movement** - Link can move in four directions: up (:arrow_up_small: or W), down (:arrow_down_small: or S), left (:arrow_backward: or A) and right (:arrow_forward: or D).
-----
### PLANNED FEATURES

- **Attack:crossed_swords: -** When you press the SPACE bar, Link will fiercely swing his sword. Use this to defend yourself against the Exceptions.
- **Shoot:bow_and_arrow: -** Press the left mouse button to make Link shoot his trusty bow. His arrows may be limited, but they sure are lethal!
- **Collect Object:mag: -** When Link is in the same position as an object he collects it. Use to obtain all the objects of the game.
- **Menu -** There will be a menu when the game opens with the start and instructions options.
- **Game Over -** If the player loses the game, there will be a message on the screen.
- **Collision -** A collision will occur when Link is in the same position as an enemy, causing our hero to take damage.
- **Lose life -** Link starts out with 3 lives, represented as hearts on the screen. Everytime an enemy collides with him, Link will take damage and lose some hearts, depending on the strenght of the attack.

-----

### DESIGN

> For further insight into our implementation of the design patterns, please consult the UML Class diagram above

#### ALL ELEMENTS SHOULD BEHAVE SIMILARLY

**Problem in Context**

When considering how we wanted to program the distinct elements that compose our game, we realized that treating every single element individually would clutter our code and convolute the implementation of a game loop. In fact, some elements, such as the different kinds of enemies Link will face, behave almost identically, to the point where it would be foolish to separate them.

**The Pattern**

As such, we applied the Composite pattern, which, succinctly, allows us to view a group of similar objects as a single instance of an object. Its formal definition can be found [here](https://refactoring.guru/design-patterns/composite).

**Implementation**

Classes that share properties inherit/implement a superclass/interface, respectively. For instance:

- **Models -** All elements inherit the Element abstract class. Moreover, elements that can move inherit the MovingElement abstract class, which in turn also extends Elements.
- **Presenters -** The dungeon and element presenters both extend the Presenter abstract class. This class defines the abstract method ```update(graphics, action)```
- **Viewers -** The dungeon and element viewers implement the Viewer interface, which defines the ```draw(graphics, model)``` function

The classes that serve as the basis of our Composite pattern can be found in the following files:

- [Element](https://github.com/FEUP-LDTS-2022/project-l08gr02/blob/master/src/main/java/com/l08gr02/zelda/models/elements/Element.java) (abstract class)
- [MovingElement](https://github.com/FEUP-LDTS-2022/project-l08gr02/blob/master/src/main/java/com/l08gr02/zelda/models/elements/MovingElement.java) (abstract class)
- [Presenter](https://github.com/FEUP-LDTS-2022/project-l08gr02/blob/master/src/main/java/com/l08gr02/zelda/presenters/Presenter.java) (abstract class)
- [Viewer](https://github.com/FEUP-LDTS-2022/project-l08gr02/blob/master/src/main/java/com/l08gr02/zelda/viewers/Viewer.java) (interface)

**Consequences**

Using the Composite pattern, we have achieved the following:

- Our code is easier to interpret, as the purpose of most classes can be pinpointed if we examine the classes it extends or the interfaces it implements.
- Unit testing is more efficient, as we can test several classes at a time (provided they share the same properties)

###

#### THE SOLID PRINCIPLES MUST BE RESPECTED

**Problem in Context**

In 2000, Robert C. Martin published five design principles that would revolutionise object-oriented programming as we know it: the SOLID principles. Among many other benefits, applying these principles increases code reusability and assures the structure of a project does not collapse every time a new feature is added. Because of this, we had to brainstorm a way to structure our code without defying SOLID.

**The Pattern**

We applied the MVP (Model-View-Presenter) architectural pattern, wherein the Presenter establishes the connection between the data (Model) and the *User Interface* (Viewers). It is a variation of the more widely known MVC (Model-View-Controller) pattern.

To find out more about MVP, click [here](https://www.geeksforgeeks.org/mvp-model-view-presenter-architecture-pattern-in-android-with-example/).

![MVP illustrated](<img src="https://github.com/FEUP-LDTS-2022/project-l08gr02/tree/master/docs/MVP.png" width="200" />)

**Implementation**

Classes are divided in one of three subtypes:

- **Models -** Contain the data of the game and functions that can alter it
- **Presenter -** Function as the "*middle man*" between the Models and the Viewers. They are responsible for appropriately calling all methods defined in the Models (to update the game data) and the Viewers (to update the GUI)
- **Viewers:** According to the current data (which is provided to them by the Presenters), display the game on the screen

**Consequences**

The following benefits were made possible by using the MVP pattern:

- It is significantly easier to add new features
- Refactoring our code is more accessible

------

### TESTING

------

### SELF-EVALUATION

- **Andreia Silva:** TBD
- **Gonçalo Nadais de Pinho:** TBD
- **Tomás Sucena Lopes:** TBD
