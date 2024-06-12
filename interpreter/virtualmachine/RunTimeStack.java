package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private List<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public String verboseDisplay()
    {
        return null;
    }

    public int peek()
    {
        return this.runTimeStack.getLast();
    }

    public int push(int i )
    {
        this.runTimeStack.add(i);

        return i;
    }

    public int pop()
    {
        return 0;
    }

    public int store(int offsetInFrame)
    {
        return 0;
    }

    public int load(int offsetInFrame)
    {
        return 0;
    }

    public int newFrameAt(int offsetFromTopOfRunStack)
    {
        return 0;
    }

    public int popFrame()
    {
        return 0;
    }
}
