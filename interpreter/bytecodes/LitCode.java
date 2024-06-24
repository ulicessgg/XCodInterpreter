package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.List;

public class LitCode extends ByteCode
{
    private String label;

    private int value;

    private List<String> args;
    public void init(ArrayList<String> s)
    {
        this.value = Integer.parseInt(s.get(1));
        if(s.size() > 2)
        {
            this.label = s.get(2);
        }
    }

    public void execute(VirtualMachine vm)
    {
        vm.push(this.value);
    }

    public String toString()
    {
        String retVal = "LIT " + this.value;

        if(this.label == null)
        {
            retVal += " " + this.label + "int " + this.value;
        }

        return retVal;
    }
}