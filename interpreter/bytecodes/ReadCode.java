package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class ReadCode extends ByteCode
{
    public void init(List<String> s)
    {

    }

    public void execute(VirtualMachine vm)
    {

    }

    public String toString()
    {
        String retVal = "READ ";

        return retVal;
    }
}