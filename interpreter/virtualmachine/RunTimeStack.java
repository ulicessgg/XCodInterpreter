package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.EmptyStackException;
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
        String display = "";

        for (int i = 0; i < framePointer.size(); i++)
        {
            int start = framePointer.get(i);
            int end;

            if(i + 1 < framePointer.size())
            {
                end = framePointer.get(i + 1);
            }
            else
            {
                end =  runTimeStack.size();
            }

            display = "[";

            for(int j = start; j < end; j++)
            {
                display += runTimeStack.get(j);
                if(j < end - 1)
                {
                    display += ", ";
                }
            }
            display += "]";
        }
        return display.trim();
    }

    public int peek() {
        if (runTimeStack.isEmpty())
        {
            throw new EmptyStackException();
        }
        return this.runTimeStack.getLast();
    }

    public int push(int i )
    {
        this.runTimeStack.add(i);

        return i;
    }

    public int pop()
    {
        if (runTimeStack.isEmpty())
        {
            throw new EmptyStackException();
        }
        return this.runTimeStack.removeLast();
    }

    public int getFrames() // was suggested to add this so far empty exception is still thrown due to pop
    {
        return this.runTimeStack.size() - framePointer.peek();
    }

    public int store(int offsetInFrame)
    {
        if (runTimeStack.isEmpty())
        {
            throw new EmptyStackException();
        }

        int storedItem = this.pop();

        runTimeStack.set(offsetInFrame + framePointer.peek(), storedItem);

        return storedItem;
    }

    public int load(int offsetInFrame)
    {
        if (framePointer.isEmpty() || framePointer.peek() + offsetInFrame >= runTimeStack.size())
        {
            throw new IndexOutOfBoundsException();
        }
        return this.push(runTimeStack.get(offsetInFrame + framePointer.peek()));
    }

    public void newFrameAt(int offsetFromTopOfRunStack)
    {
        if (offsetFromTopOfRunStack > runTimeStack.size())
        {
            throw new IndexOutOfBoundsException();
        }
        framePointer.push(runTimeStack.size() - offsetFromTopOfRunStack);
    }

    public void popFrame()
    {
        if (framePointer.isEmpty())
        {
            throw new EmptyStackException();
        }
        int start = framePointer.pop();
        while(runTimeStack.size() > start)
        {
            this.pop();
        }
    }
}
