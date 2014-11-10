game-template
=============

## Playing the Game
'a'     Move player ship left
'd'     Move player ship right
<Space> Fire missile from player ship
'q'     Quit Game


## Which classes do what...
The behavior of the enemy ship, which is currently nothing, lives in com.thoughtworks.gametemplate.game.entities.Enemy
The EnemyFactory class creates new Enemies. This is called in World.update.



## Advice on how to succeed
* Work in pairs (you don't have to, but it usually let's you get more done)
* Make whatever assumptions you like about how to implement these features. You can also ask for more details if you like. 
* Do the simplest thing that completes each feature
* Understand what it means to finish the feature before you start coding
* Only work on one feature at a time
* Work on the features in order
* Make very small changes and run the game after each change
* Commit frequently
* Don't spend a lot of time trying to design your code before you write it
* Do spend time cleaning up and refactoring your code as it grows

## Previously Completed Features
* I can see my ship
* I can see a star field in the background behind my ship
* I can see an enemy ship
* I can see a projectile
* I can move my ship left and right but it never moves off the screen
* I can fire a missile (that moves straight up) from my ship
* When a missile touches an enemy ship that ship is destroyed
* Instead of the initial enemy a new enemy appears every two seconds

## Features
* The enemy ship, called a Bouncer, starts near the top of screen and bounces between the edges of the screen
* Half of the new ships that appear are a second kind of enemy ship, called a Wanderer. Which moves randomly around the
    screen (in both the x and y directions), but never moves off the screen
* The Bouncer drops Bombs that move straight down
* The game ends when an enemy projectile hits my ship
* The Wanderer fires Roving Missiles move down and randomly shift left or right
* The new enemy that appears moves like a Bouncer or a Wanderer (choose randomly) and fires either Bombs or Roving Missiles
* Enemy ships can also move in a circle (Circler)
* The game ends when an enemy ship hits my ship
* Enemy ships can teleport closer to my ship instead of firing (Seeker)

