package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode
{

    private String label;
    public void init(ArrayList<String> s)
    {
        if(!s.isEmpty())
        {
            label = s.getFirst();
        }
    }

    public void execute(VirtualMachine vm)
    {
    }

    public String getLabel()
    {
        return label;
    }
}