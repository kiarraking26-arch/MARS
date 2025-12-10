# Hogwarts Battle Simulation
# Demonstrates casting spells, brewing potions, teleporting, and using items

# Initialize player powers
harddrop $t0, $zero, 5   # Player 1
harddrop $t1, $zero, 3   # Player 2
harddrop $t2, $zero, 7   # Player 3

# Brew potions
brew
brew

# Learn new spells (double power)
learn $t0
learn $t2

# Cast spells on opponents
cast $t1, 2
cast $t2, 3

# Curse opponents
curse $t1
curse $t2

# Teleport if enough power
tp $t0, BattleStart

# Use magic items
use
use

# Battle rounds loop
BattleStart:
cast $t0, 1
cast $t1, 2
learn $t0
learn $t1
downstack
combo 3
viewboard

# Check for game over or all-clear
topout
allclear
tetris
