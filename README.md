Basic Instructions:

cast (I) cast $t0, imm
brew (R) brew
tp (I) tp $t0, label
learn (R) learn $t0
use (R) use
curse (R) curse $t0

Magic Operations:

WINGARDIUM (R) WINGARDIUM R1,R2,R3
REDUCTO (R) REDUCTO R1,R2,R3
MUFFLIATO (R) MUFFLIATO R1,R2,shamt
QUIETUS (R) QUIETUS R1,R2,shamt
SCURGIFY (R) SCURGIFY R1
EXPECTO_PATRONUM (R) EXPECTO_PATRONUM R1
AVADA_KEDAVRA (R) AVADA_KEDAVRA R1
PROTEGO (R) PROTEGO R1,R2
TIME_TURNER (R) TIME_TURNER R1,shamt
POLYJUICE (R) POLYJUICE R1,R2
CONFUNDO (R) CONFUNDO R1
HORCRUX (R) HORCRUX R1,R2
OBLIVIATE (I) OBLIVIATE R1,imm
PORTKEY (I) PORTKEY R1,label
GEMINO (R) GEMINO R1,R2

Example Program:

brew
cast $t0,5
tp $t0,Destination

Destination:
learn $t0
curse $t1
use
exit
