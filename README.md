# Farkle Game

## Introduction

The game of Farkle is a dice game that has been around for a long time. It is a game that is played with six dice. The game is played by two or more players. The game is played in rounds. The goal of the game is to be the first player to reach a certain number of points

There are some rules to calculate the points based on the dice rolled.

## Requirements

Write an application in Kotlin to expose an endpoint to receive a list of dice rolls and return the points scored for that roll.

The rules for scoring are as follows:

- A single one (100 points) or a single five (50 points) is worth points
- Triple ones [1,1,1] are worth 1000 points
- Triple two's [2,2,2] are worth 200 points
- Triple three's [3,3,3] are worth 300 points
- Triple four's [4,4,4] are worth 400 points
- Triple five's [5,5,5] are worth 500 points
- Triple six's [6,6,6] are worth 600 points

Additional rules to be implemented:

- Four of a kind is worth the value of the dice times 2 (i.e. 4 fours is worth 800 points)
- Five of a kind is worth the value of the dice times 4 (i.e. 5 fives is worth 2000 points)
- Six of a kind is worth the value of the dice times 8 (i.e. 6 sixes is worth 4800 points)
- Three pairs is worth 800 points (i.e. 2,2,3,3,4,4)
- Straight from 1 to 6 is worth 1200 points (i.e. 1,2,3,4,5,6)

Try to implement the scenarios using TDD. Implements first the test to check the calculation and after that implements the code to pass the test.

## BDD

In the following section we will describe the scenarios that we will implement in the application using BDD definition.

Here there is a list of examples that we would be implemented:

- Given a roll of [1, 1, 1, 5, 1, 2], when the user calculates the score, then the result is 1150 points. The explanation is 3 ones are 1000 points and the last one is 50 points and the single 1 at the end is 100 points more.
- Given a roll of [2, 3, 4, 6, 2, 2], when the user calculates the score, then the result is 0 points. The explanation is that there are no single 1 or 5 and there are no triples or more.
- Given a roll of [1, 5, 1, 5, 1, 5], when the user calculates the score, then the result is 450 points. The explanation, 3 independent ones are 300 points and 3 independent fives are 150 points.
- Given a roll of [1, 1, 1, 5, 5, 5], when the user calculates the score, then the result is 1500 points. The explanation 3 ones in a row are 1000 points and 3 fives in a row are 500 points. 
- Given a roll of [1, 1, 1, 5, 1, 2], when the user calculates the score, then the result is 1150 points. The explanation is 3 ones in a row are 1000 points, 1 independent one is 100 and 1 independent five is 50 points. 
- Given a roll of [1, 1, 5, 5, 2, 2], when the user calculates the score, then the result is 300 points. The explanation is 2 independent ones are 200 points and 2 independent fives are 100 points.
- Given a roll of [6, 6, 6, 6, 5, 5], when the user calculates the score, then the result is 1300 points. The explanation is 4 sixes are 1200 points, 2 fives are 100 points.
- Given a roll of [4, 4, 4, 4, 4, 5], when the user calculates the score, then the result is 1650 points. The explanation is 5 fours are 1600 points, 1 five is 50 points.
- Given a roll of [3, 3, 3, 3, 3, 3], when the user calculates the score, then the result is 2400 points. The explanation is 6 threes are 2400 points.

