package interpreter.virtualmachine;

import java.util.Stack;
import interpreter.loaders.Program;
import interpreter.bytecodes.ByteCode;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        verboseMode;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
        this.verboseMode = false;
    }

    public void executeProgram()
    {
        isRunning = true;

        while(isRunning)
        {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if(verboseMode)
            {
                System.out.println(code);
                System.out.println(runTimeStack.verboseDisplay());
            }
            programCounter++;
        }
    }

    public void setRunning(boolean run)
    {
        this.isRunning = run;
    }

    public void setVerboseMode(boolean mode)
    {
        this.verboseMode = mode;
    }

    public int pop()
    {
        return this.runTimeStack.pop();
    }

    public void setProgramCounter(int address)
    {
        this.programCounter = address;
    }

    public int getProgramCounter()
    {
        return this.programCounter;
    }

    public void pushReturnAddress(int address)
    {
        returnAddress.push(address);
    }

    public int popReturnAddress(int address)
    {
        return returnAddress.pop();
    }
}
