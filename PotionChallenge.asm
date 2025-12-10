# Hogwarts Potion Brewing Challenge
# Demonstrates brewing, using potions, slow gravity, and combos

# Initialize registers for ingredients/potions
harddrop $t0, $zero, 0
harddrop $t1, $zero, 0
harddrop $t2, $zero, 0
harddrop $t3, $zero, 0

# Brew multiple potions
brew
brew
brew

# Use potions to increase power
use
use

# Slow gravity challenge
slowgravity $t0, $t1, 2
slowgravity $t2, $t3, 1

# Combine potions for maximum effect
combo 5

# Check current board/register values
viewboard

# Learn advanced spell
learn $t0
learn $t2

# Final potion use
use
