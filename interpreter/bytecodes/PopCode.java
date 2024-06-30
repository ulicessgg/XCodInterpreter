package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class PopCode extends ByteCode
{
    private int num;

    public void init(List<String> s)
    {
        if(!s.isEmpty())
        {
            this.num = Integer.parseInt(s.get(1));
        }
    }

    public void execute(VirtualMachine vm)
    {
        vm.pop(num);
    }

    public String toString()
    {
        String retVal = "POP " + this.num;

        return retVal;
    }
}