package mars.mips.instructions.customlangs;

import mars.simulator.*;
import mars.mips.hardware.*;
import mars.mips.instructions.syscalls.*;
import mars.*;
import mars.util.*;
import java.util.*;
import java.io.*;
import mars.mips.instructions.*;
import java.util.Random;

public class HogwartsAssembly extends CustomAssembly {

    private static int magicItem = -1;

    @Override
    public String getName() {
        return "Hogwarts Assembly";
    }

    @Override
    public String getDescription() {
        return "Cast spells, brew potions, teleport, curse opponents, and use magical items!";
    }

    @Override
    protected void populate() {

        instructionList.add(
            new BasicInstruction(
                "WINGARDIUM R1,R2,R3",
                "Add R2 + R3 -> R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 R2 R3 R1 00000 100000",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int result = RegisterFile.getValue(ops[1]) + RegisterFile.getValue(ops[2]);
                        RegisterFile.updateRegister(ops[0], result);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "REDUCTO R1,R2,R3",
                "Subtract R2 - R3 -> R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 R2 R3 R1 00000 100010",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int result = RegisterFile.getValue(ops[1]) - RegisterFile.getValue(ops[2]);
                        RegisterFile.updateRegister(ops[0], result);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "MUFFLIATO R1,R2,shamt",
                "Shift R2 left by shamt -> R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 R2 R1 shamt 000000",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = RegisterFile.getValue(ops[1]) << ops[2];
                        RegisterFile.updateRegister(ops[0], val);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "QUIETUS R1,R2,shamt",
                "Shift R2 right by shamt -> R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 R2 R1 shamt 000010",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = RegisterFile.getValue(ops[1]) >>> ops[2];
                        RegisterFile.updateRegister(ops[0], val);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "SCURGIFY R1",
                "Clear register R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 R1 00000 100101",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        RegisterFile.updateRegister(ops[0], 0);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "DIFFINDO R1,R2,label",
                "Branch if R1==R2",
                BasicInstructionFormat.I_BRANCH_FORMAT,
                "000100 R1 R2 offset",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        if (RegisterFile.getValue(ops[0]) == RegisterFile.getValue(ops[1])) {
                            Globals.instructionSet.processBranch(ops[2]);
                        }
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "LOCO_MOTOR label",
                "Jump to label",
                BasicInstructionFormat.I_FORMAT,
                "000010 offset",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        Globals.instructionSet.processBranch(ops[0]);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "EXPECTO_PATRONUM R1",
                "Random positive value -> R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 R1 00000 110000",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = new Random().nextInt(100) + 1;
                        RegisterFile.updateRegister(ops[0], val);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "AVADA_KEDAVRA R1",
                "Set R1 = 0, set Kill Flag",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 R1 00000 110001",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        RegisterFile.updateRegister(ops[0], 0);
                        RegisterFile.updateRegister(21, 1);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "PROTEGO R1,R2",
                "Reflect negative -> R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 R2 00000 R1 00000 110010",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = RegisterFile.getValue(ops[1]);
                        if (val < 0) val = -val;
                        RegisterFile.updateRegister(ops[0], val);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "TIME_TURNER R1,shamt",
                "Rotate R1 left by shamt",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 R1 R1 shamt 110011",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = Integer.rotateLeft(RegisterFile.getValue(ops[0]), ops[1]);
                        RegisterFile.updateRegister(ops[0], val);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "POLYJUICE R1,R2",
                "Swap nibbles -> R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 R2 00000 R1 00000 110100",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = RegisterFile.getValue(ops[1]);
                        int swapped = ((val & 0xF0F0F0F0) >>> 4) | ((val & 0x0F0F0F0F) << 4);
                        RegisterFile.updateRegister(ops[0], swapped);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "CONFUNDO R1",
                "Randomize lower 8 bits",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 R1 00000 110101",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = RegisterFile.getValue(ops[0]);
                        val = (val & 0xFFFFFF00) | new Random().nextInt(256);
                        RegisterFile.updateRegister(ops[0], val);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "HORCRUX R1,R2",
                "Upper 16 bits -> R1, TEMP = lower",
                BasicInstructionFormat.R_FORMAT,
                "000000 R2 00000 R1 00000 110110",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = RegisterFile.getValue(ops[1]);
                        RegisterFile.updateRegister(ops[0], val >>> 16);
                        RegisterFile.updateRegister(22, val & 0xFFFF);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "OBLIVIATE R1,imm",
                "Clear lower imm bits",
                BasicInstructionFormat.I_FORMAT,
                "001000 00000 R1 imm",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        int val = RegisterFile.getValue(ops[0]);
                        val = val & (~((1 << ops[1]) - 1));
                        RegisterFile.updateRegister(ops[0], val);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "PORTKEY R1,label",
                "Load address -> R1",
                BasicInstructionFormat.I_FORMAT,
                "001001 00000 R1 offset",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        RegisterFile.updateRegister(ops[0], ops[1]);
                    }
                }
            )
        );

        instructionList.add(
            new BasicInstruction(
                "GEMINO R1,R2",
                "Copy R2 -> R1",
                BasicInstructionFormat.R_FORMAT,
                "000000 R2 00000 R1 00000 110111",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int[] ops = statement.getOperands();
                        RegisterFile.updateRegister(ops[0], RegisterFile.getValue(ops[1]));
                    }
                }
            )
        );

    }
}
