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

    public void setVerboseMode(boolean o)
    {
        this.verboseMode = o;
    }
}
