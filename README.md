# SUTD PADI EXPOSÉ Education Fair 2022 Kiasu Course Trial (Computer Science)

> Exploring Singapore Education

The course trial will teach basic programming concepts in [Java](https://www.oracle.com/java/). The design project for this course trial would be implementing the 99 card game on a command-line terminal. Reference solution code, as well as other relevant materials such as the workshop slides presented during the lecture, exercise example code, and any other potential extra materials, are included in this repository.

Note that any reference solution code implemented in this repository is simply just that, a reference. It is definitely not the only way to implement the system requirements/functionalities of the program.

## Introduction to Ninety Nine

The card game [99 (Ninety Nine)](<https://en.wikipedia.org/wiki/Ninety-nine_(addition_card_game)>) is a simple turn-based multiplayer game, where each player takes a turn playing a card from their hand, and adds the value of the card to the running total. The player who causes the total to go over 99 loses the round (or game).

## Gameplay Mechanics

- There are N players. The user is one of them (with ID 0), while the other N-1 players would be operated by the CPU. CPU players would play in a random manner (instead of in an optimized manner).
- Each player is dealt M cards.
- The point total starts at zero and each card adds its face value in points (example: a 5 is worth five points, a face card is worth 10 points) except for certain cards that have special values or meanings:
  - A 4 reverses play (and does not change the total number of points)
  - A 9 is a pass (and does not change the total number of points)
  - A 10 subtracts 10 points from the total
  - A King takes the point total to 99 (or keeps it 99 if the total is already 99)
  - An Ace adds either 1 or 11 points, chosen by the player who plays it
- After each card is played, the new total is updated accordingly and the player draws a random replacement card from an infinite card pool/stack/deck.
- Each player must play a card without sending the total number of points higher than 99.
- If a player sends the total number of points higher than 99, that player loses and the current running total number of points is reset to 0.
- Once N-1 players are eliminated, the remaining sole player wins that game round.

## Concepts Involved

- If-else conditionals
- While loops
- Switch-case statements
- `Scanner` for user input
- CLI argument parsing
- Classes
- Class methods
- Explicit constructor invocation
- `ArrayList`
- Enums
- `Random`/`SecureRandom`
- Guard clauses
- Defensive checks against bad user input
- Infinite `while (true)` loops as the main game loop
- Modular program/software design/architecture

## Bonus Challenge Questions

If you are interested, you may explore these additional concepts/features relevant to coding in the Java language and perhaps implement them in your own free time:

- Class inheritance
- Interfaces
- Unit and system testing using `JUnit`
- Implement multiple lives for each player. If a player sends the total number of points higher than 99, they lose a life, their cards are collected, and they are dealt a new hand.
- Add a GUI to allow the players to play the game just like a normal video game. For extra bonus points, the GUI should take into account the possibility when there are a lot of players/cards and adjust the visual aspect accordingly so as to not clutter the screen too much.
- Add multiplayer mode. Bonus points if the multiplayer can be done both locally and online (i.e., over the network/Internet).
- Implement CPU players that play in an optimized manner. Each CPU player checks the current running total value and selects the best playable card, with possibly an optional lookahead to some degree/level. Each player should not know what cards are possessed by other players, but other players could potentially infer those cards based on behavior using game theory.

## Acknowledgements

This course was brought about by collaborating Indonesian students currently studying in tertiary education institutes in Singapore for Indonesian students.

[SUTD EXPOSÉ Education Fair 2022 Kiasu Course Trial](https://www.xposedufair.com/kiasu-courses/computer-science) Team Members from [PADI](https://sutdindonesia.github.io/):

- [Ferry Chandra](https://github.com/FerryC13)
- [Filbert Cia](https://github.com/FolkLoreee)
- [Sean Gunawan](https://github.com/naffins)
- [James Raphael Tiovalen](https://github.com/jamestiotio)
- [Edward Marco Moktar](https://www.linkedin.com/in/edwardmoktar)
- [Jonathan Davinius Layardi](https://www.linkedin.com/in/jonathanlayardi)
- [Erick Chandra](https://github.com/erickch123)
- [Nathan Chang](https://www.linkedin.com/in/nathan-chang-a0a23b212)
- [Michelle Ordelia Sumaryo](https://www.linkedin.com/in/michelleordeliasumaryo)

Credits also to the respective organizer teams from [PPI Singapura](https://www.ppisingapura.com/) and [PINUS](https://pinusonline.org/) (from NUS)! In particular, thanks to:

- [Florentiana Yuwono](https://github.com/florentianayuwono)
- [Tiffany Irene Prasetio](https://www.linkedin.com/in/tiffanyireneprasetio)
- [Victoria Magdalena](https://www.linkedin.com/in/victoriamagdalena)
- [Jason Christopher](https://github.com/jasonchristopher21)
- [Farrel Dwireswara Salim](https://github.com/sugiyem)
