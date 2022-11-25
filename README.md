# project-l08gr02 - ZELDA
project-l08gr02 created by GitHub Classroom

> Join Link as he explores the unoptimized terminal of Lanterna

After saving Hyrule once again, Link decides to take a well-earned nap. However, he is cursed in his sleep by a furious programmer that could not beat his last game. When he wakes up from his slumber, our hero finds himself in a treacherous Lanterna terminal. Embark on a brand new adventure and help Link escape the evil Exceptions and Null Pointers!

This project was developed by Andreia Silva (up202108769@up.pt), Gonçalo Nadais de Pinho (up202108672@up.pt) and Tomás Sucena Lopes (up202108701@up.pt) for LDTS 2022⁄23.

-----
### UML Class Diagram

The following UML diagram represents how the various game classes interact with each other:

![UML Class diagram](docs/uml.png)

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
- **Lose life -** The game starts with 3 lives, represented as hearts on the screen. Everytime an enemy collides with Link, he will take damage and lose some hearts.
-----
### DESIGN

#### ALL ELEMENTS SHOULD BEHAVE SIMILARLY

**Problem in Context**

When considering how we wanted to program the distinct elements that compose our game, we realized that treating every single element individually would clutter our code and convolute the implementation of a game loop. In fact, some elements, such as the different kinds of enemies Link will face, behave almost identically, to the point where it would be foolish to separate them.

**The Pattern**

As such, we applied the Composite pattern, which allows us to

**Implementation**

Classes that share properties inherit/implement a superclass/interface, respectively. For instance:

- **Models:** All elements inherit the Element abstract class. Moreover, elements that can move inherit the MovingElement abstract class, which in turn also extends Elements.
- **Presenters:** The dungeon and element presenters both extend the Presenter abstract class. This class defines the abstract method ```update(graphics, action)```
- **Viewers:** The dungeon and element viewers implement the Viewer interface, which defines the ```draw(graphics, model)``` function

The classes that serve as the basis of our Composite pattern can be found in the following files:

- [Element](https://github.com/FEUP-LDTS-2022/project-l08gr02/blob/master/src/main/java/com/l08gr02/zelda/models/elements/Element.java) (abstract class)
- [MovingElement](https://github.com/FEUP-LDTS-2022/project-l08gr02/blob/master/src/main/java/com/l08gr02/zelda/models/elements/MovingElement.java) (abstract class)
- [Presenter](https://github.com/FEUP-LDTS-2022/project-l08gr02/blob/master/src/main/java/com/l08gr02/zelda/presenters/Presenter.java) (abstract class)
- [Viewer](https://github.com/FEUP-LDTS-2022/project-l08gr02/blob/master/src/main/java/com/l08gr02/zelda/viewers/Viewer.java) (interface)

In addition, the UML class diagram above further illustrates how we approached this design pattern.

**Consequences**

Using the Composite pattern, we have achieved the following:

- Our code is easier to interpret, as the purpose of most classes can be pinpointed if we examine the classes it extends or the interfaces it implements.
- Unit testing is more efficient, as we can test several classes at a time (provided they share the same properties)

------

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

------

### SELF-EVALUATION

- **Andreia Silva:** TBD
- **Gonçalo Nadais de Pinho:** TBD
- **Tomás Sucena Lopes:** TBD

