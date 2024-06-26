package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class LabelCode extends ByteCode
{
    private String label;

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
        String retVal = "LABEL" + label;

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
}