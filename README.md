game-template
=============

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

## Features
* The enemy ship (Bouncer) starts at the top left corner of screen and bounces between the edges of the screen
* There is a second enemy ship that starts at the top right corner of the screen
* The second enemy ship (Wanderer) moves randomly around the screen (in both the x and y directions), but never moves off the screen
* The Bouncer drops Bombs that move straight down
* The game ends when an enemy projectile hits my ship
* The Wanderer fires Roving Missiles move down and randomly shift left or right
* Instead of the initial two enemies a new enemy appears every second alternating between Bouncers and Wanderers
* The new enemy that appears can move like a Bouncer or a Wanderer and fires either Bombs or Roving Missiles 
* Enemy ships can also move in a circle (Circler)
* The game ends when an enemy ship hits my ship
* Enemy ships can teleport closer to my ship instead of firing (Seeker)

