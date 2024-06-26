package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class GoToCode extends ByteCode
{
    private String label;
    private int address;

    public void init(List<String> s)
    {
        if(!s.isEmpty())
        {
            label = s.getFirst();
        }
    }

    public void execute(VirtualMachine vm)
    {

    }

    public String toString()
    {
        String retVal = "GOTO " + label;

        return retVal;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return this.label;
    }

    public void setAddress(int address)
    {
        this.address = address;
    }

    public int getAddress()
    {
        return this.address;
    }
}