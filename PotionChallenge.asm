# Hogwarts Potion Brewing Challenge
# Demonstrates brewing, using potions, slow gravity, and combos

# Initialize registers for ingredients/potions
WINGARDIUM $t0,$zero,$t0
WINGARDIUM $t1,$zero,$t1
WINGARDIUM $t2,$zero,$t2
WINGARDIUM $t3,$zero,$t3

# Brew multiple potions (random boost)
EXPECTO_PATRONUM $t0
EXPECTO_PATRONUM $t1
EXPECTO_PATRONUM $t2

# Use potions to increase power
GEMINO $t0,$t1
GEMINO $t2,$t3

# Slow gravity challenge
MUFFLIATO $t0,$t0,2
MUFFLIATO $t2,$t2,1

# Combine potions for maximum effect
TIME_TURNER $t0,3
TIME_TURNER $t1,3

# Check current board/register values
VIEWBOARD:  # Could be a comment, or just simulate effect
EXPECTO_PATRONUM $t0
EXPECTO_PATRONUM $t2

# Learn advanced spell
GEMINO $t0,$t0
GEMINO $t2,$t2

# Final potion use
EXPECTO_PATRONUM $t0
EXPECTO_PATRONUM $t2
