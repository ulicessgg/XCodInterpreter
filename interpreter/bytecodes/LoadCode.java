package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class LoadCode extends ByteCode
{
    private int offset;
    private String identifer;

    public void init(List<String> s)
    {
        if(!s.isEmpty())
        {
            this.offset = Integer.parseInt(s.getFirst());
        }
        if(s.size() > 1)
        {
            this.identifer = s.get(1);
        }
    }

    public void execute(VirtualMachine vm)
    {
        vm.load(offset);
    }

    public String toString()
    {
        String retVal = "LOAD " + offset;

        if(identifer != null)
        {
            retVal = retVal + " " + identifer + " <load " + identifer + ">";
        }

        return retVal;
    }
}