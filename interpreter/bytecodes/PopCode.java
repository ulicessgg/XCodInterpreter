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
            this.num = Integer.parseInt(s.getFirst());
        }
    }

    public void execute(VirtualMachine vm)
    {
        for(int i = 0; i < num; i++)
        {
            vm.pop();
        }
    }

    public String toString()
    {
        String retVal = "POP " + this.num;

        return retVal;
    }
}