# Hogwarts Tournament Simulation
# Showcases casting spells, curses, teleportation, and winning conditions

# Initialize player powers
harddrop $t0, $zero, 8
harddrop $t1, $zero, 6
harddrop $t2, $zero, 4
harddrop $t3, $zero, 7

# Pre-round magic boost
brew
brew
learn $t0
learn $t1

# Round 1: Cast spells and curse opponents
cast $t2, 3
cast $t3, 2
curse $t1
curse $t0

# Round 2: Teleport if power sufficient
tp $t2, TournamentRound2

# Use magic items strategically
use
use

# Tournament rounds loop
TournamentRound2:
cast $t0, 2
cast $t1, 1
downstack
combo 4
viewboard

# Final scoring
allclear
tetris
topout
