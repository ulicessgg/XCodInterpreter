package interpreter.virtualmachine;

import java.util.Stack;
import interpreter.loaders.Program;
import interpreter.bytecodes.ByteCode;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private Program program;
    private int programCounter;
    private boolean isRunning;
    private boolean verboseMode;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
        this.verboseMode = false;
    }

    public void executeProgram() {
        isRunning = true;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if (verboseMode) {
                System.out.println(code);
                System.out.println(runTimeStack.verboseDisplay());
            }
            programCounter++;
        }
    }

    public void newFrame(int args) // for args
    {
        this.runTimeStack.newFrameAt((args));
    }

    public void storeReturnAddress(int address) // for call
    {
        this.returnAddress.push(address);
    }

    public void setRunning(boolean run) // for halt
    {
        this.isRunning = run;
    }

    public int push(int value) // for litCode
    {
        return this.runTimeStack.push(value);
    }

    public int load(int offset) // for load
    {
        return this.runTimeStack.load(offset);
    }

    public int pop() // for pop
    {
        return this.runTimeStack.pop();
    }

    public void popFrame() // for return
    {
        this.runTimeStack.popFrame();
    }

    public void popReturnAddress() // for return
    {
        this.programCounter = this.returnAddress.pop();
    }

    public int store(int offset) // for store
    {
        return this.runTimeStack.store(offset);
    }

    public void setVerboseMode(boolean mode) // for verbose
    {
        this.verboseMode = mode;
    }

    public boolean getVerboseMode() // for verbose
    {
        return this.verboseMode;
    }

    public int peek() // for write
    {
        return this.runTimeStack.peek();
    }
}
