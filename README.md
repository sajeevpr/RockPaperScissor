1. Build the Project : mvn clean install
2. Test the project : mvn clean test
3. This project is having the following structure
  ```
       a. com.imc.game.constants - Constant classes
       b. com.imc.game.model.exception - Exception classes
       c. com.imc.game.hand - Hand implementations, Eg. Rock, Paper, Scissor
       d. com.imc.game.player - Player implementations, Eg. HumanPlayer, ComputerPlayer
       e. com.imc.game.score - Score board implementation classes
       f. com.imc.game.util - Utility classes
       g. com.imc.game.visitor - Visitor classes, Eg. Paper, Rock & Scissor Visitor classes
       h. com.rps.game.Game - Class where a single game is played with multiple rounds
       i. com.rps.game.Application - Main class where the Game begins
  ```
4. Assumptions
   ```
    a. Game is always played between Computer & the user
    b. Number of hands may change in the future
    c. Score board will always have two players - user and computer
    d. There will be only two hands involved in the game
   ```
5. Design decisions
   ```
    a. Hands are implemented in its own class assuming that more hands may come in the future
    b. Hand visitors are implemented to compute the result of play between two hands
    c. Simple score board is designed keeping in view that only two players are possible in the game.
   ```
6. Start application - Run the java class - Application.java