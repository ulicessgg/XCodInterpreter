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
        return null; //need to implement still
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
        return this.runTimeStack.removeLast();
    }

    public int store(int offsetInFrame)
    {
        int storedItem = runTimeStack.removeLast();
        //originally thought of using set but it would only overwrite the value of the value at the offset index rather
        //than shifting accordingly will ask for clarification if this is expected or it should stay at set
        runTimeStack.add(offsetInFrame + framePointer.peek(), storedItem);

        return storedItem;
    }

    public int load(int offsetInFrame)
    {
        //originally used get but this would lead to two of the same ints being stored in the stack will ask for further
        //clarification if not will revert to get
        int loadedItem = runTimeStack.remove(offsetInFrame + framePointer.peek());

        runTimeStack.add(loadedItem);

        return loadedItem;
    }

    public void newFrameAt(int offsetFromTopOfRunStack)
    {
        framePointer.push(runTimeStack.size() - offsetFromTopOfRunStack);
    }

    public void popFrame()
    {
        while(runTimeStack.size() > framePointer.peek())
        {
            runTimeStack.removeLast();
        }

        framePointer.pop();
    }
}
