# Hogwarts Battle Simulation
# Demonstrates casting spells, brewing potions, teleporting, and using items

# Initialize player powers
WINGARDIUM $t0,$zero,$t0
WINGARDIUM $t1,$zero,$t1
WINGARDIUM $t2,$zero,$t2

# Brew potions
EXPECTO_PATRONUM $t0
EXPECTO_PATRONUM $t2

# Learn new spells (double power)
GEMINO $t0,$t0
GEMINO $t2,$t2

# Cast spells on opponents
REDUCTO $t1,$t1,$t0
REDUCTO $t2,$t2,$t1

# Curse opponents
PROTEGO $t1,$t1
PROTEGO $t2,$t2

# Teleport if enough power
PORTKEY $t0,BattleStart

# Use magic items
GEMINO $t0,$t1
GEMINO $t2,$t3

# Battle rounds loop
BattleStart:
REDUCTO $t0,$t0,$t1
REDUCTO $t1,$t1,$t2
GEMINO $t0,$t0
GEMINO $t1,$t1
MUFFLIATO $t0,$t0,1
TIME_TURNER $t1,3
EXPECTO_PATRONUM $t2

# Check for game over or all-clear
AVADA_KEDAVRA $t0
SCURGIFY $t1
TIME_TURNER $t2,2
