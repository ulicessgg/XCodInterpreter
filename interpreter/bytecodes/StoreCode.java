package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class StoreCode extends ByteCode
{
    private int offset;
    private String identifer;
    private int k;

    public void init(List<String> s)
    {
        if(!s.isEmpty())
        {
            this.offset = Integer.parseInt(s.get(1));
        }
        if(s.size() > 1)
        {
            this.identifer = s.get(2);
        }
    }

    public void execute(VirtualMachine vm)
    {
        this.k = vm.store(offset);
    }

    public String toString()
    {
        String retVal = "STORE " + offset;

        if(identifer != null)
        {
             retVal = retVal + " " + identifer + " " + identifer + "=" + k;
        }

        return retVal;
    }
}