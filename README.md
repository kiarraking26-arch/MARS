Instructions
WINGARDIUM (R) WINGARDIUM rd, rs, rt
Adds rs and rt and stores the result in rd.
REDUCTO (R) REDUCTO rd, rs, rt
Subtracts rt from rs and stores the result in rd.
MUFFLIATO (R) MUFFLIATO rd, rs, shamt
Shifts rs left by shamt and stores the result in rd.
QUIETUS (R) QUIETUS rd, rs, shamt
Shifts rs right by shamt and stores the result in rd.
SCURGIFY (R) SCURGIFY rd
Clears rd (sets it to 0).
DIFFINDO (I) DIFFINDO rs, rt, label
Branches to label if rs equals rt.
LOCO_MOTOR (J) LOCO_MOTOR label
Jumps to the given label.
EXPECTO_PATRONUM (R) EXPECTO_PATRONUM rd
Generates a random positive value and stores it in rd.
AVADA_KEDAVRA (R) AVADA_KEDAVRA rd
Sets rd to 0 and sets register 21 as the kill flag.
PROTEGO (R) PROTEGO rd, rs
If rs is negative, it becomes positive. Result stored in rd.
TIME_TURNER (R) TIME_TURNER rd, shamt
Rotates the bits of rd to the left by shamt.
POLYJUICE (R) POLYJUICE rd, rs
Swaps the nibbles of rs and stores the result in rd.
CONFUNDO (R) CONFUNDO rd
Randomizes the lower 8 bits of rd.
HORCRUX (R) HORCRUX rd, rs
Stores the upper 16 bits of rs in rd and the lower 16 bits in register 22.
OBLIVIATE (I) OBLIVIATE rd, imm
Clears the lower imm bits of rd.
PORTKEY (I) PORTKEY rd, label
Loads the address of label into rd.
GEMINO (R) GEMINO rd, rs
Copies rs into rd.

How to Run
Install the MARS MIPS simulator if you do not already have it.
Place the file HogwartsAssembly.java into the following directory inside the MARS source:
mars/mips/instructions/customlangs
Open your computer’s terminal and navigate to the root MARS folder.
Build the custom language using:
java -jar BuildCustomLang.jar HogwartsAssembly.java
Open MARS.
To switch to Hogwarts Assembly, select:
Tools → Language Switcher

Example Usage
Spell power boosting:
WINGARDIUM $t0, $zero, $t0
WINGARDIUM $t1, $zero, $t1
Random magic generation:
EXPECTO_PATRONUM $t0
EXPECTO_PATRONUM $t1
Offensive and defensive spells:
REDUCTO $t2, $t2, $t0
PROTEGO $t1, $t1
Teleportation:
PORTKEY $t2, NextRound
Magic duplication:
GEMINO $t0, $t0
GEMINO $t1, $t1
Time manipulation and cleansing:
TIME_TURNER $t0, 2
SCURGIFY $t3
Magic corruption and transformation:
CONFUNDO $t0
POLYJUICE $t1, $t1
HORCRUX $t2, $t4
OBLIVIATE $t3, 4
Jump control:
DIFFINDO $t0, $t1, Label
LOCO_MOTOR Label
