package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class ArgsCode extends ByteCode
{
    private int args;

    public void init(List<String> s)
    {
        if(!s.isEmpty())
        {
            args = s.size();
        }
    }

    public void execute(VirtualMachine vm)
    {
        vm.newFrame(args);
    }

    public String toString()
    {
        String retVal = "ARGS " + args;

        return retVal;
    }
}