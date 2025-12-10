# Hogwarts Tournament Simulation
# Showcase casting spells, curses, teleportation, and winning conditions

# Initialize player powers
WINGARDIUM $t0,$zero,$t0   # Power boost Player 1
WINGARDIUM $t1,$zero,$t1   # Power boost Player 2
WINGARDIUM $t2,$zero,$t2   # Power boost Player 3
WINGARDIUM $t3,$zero,$t3   # Power boost Player 4

# Pre-round magic boost
EXPECTO_PATRONUM $t0
EXPECTO_PATRONUM $t1

# Round 1: Cast spells and curse opponents
REDUCTO $t2,$t2,$t0
REDUCTO $t3,$t3,$t1
PROTEGO $t1,$t1
PROTEGO $t0,$t0

# Round 2: Teleport if power sufficient
PORTKEY $t2,TournamentRound2

# Use magical items strategically
GEMINO $t0,$t0
GEMINO $t1,$t1

# Tournament rounds loop
TournamentRound2:
REDUCTO $t0,$t0,$t1
REDUCTO $t1,$t1,$t2
EXPECTO_PATRONUM $t0
EXPECTO_PATRONUM $t1

# Final scoring
AVADA_KEDAVRA $t2
SCURGIFY $t3
TIME_TURNER $t0,2
