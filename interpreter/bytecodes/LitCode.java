package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class LitCode extends ByteCode
{
    private String label;
    private int value;

    public void init(List<String> s)
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