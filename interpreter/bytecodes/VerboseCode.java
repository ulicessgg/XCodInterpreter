package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class VerboseCode extends ByteCode
{
    private boolean value;

    public void init(List<String> s)
    {
        // need to figure this out waiting for response
    }

    public void execute(VirtualMachine vm)
    {
        vm.setVerboseMode(value);
    }

    public String toString()
    {
        String retVal = "VERBOSE ";

        if(value)
        {
            retVal = retVal + "ON";
        }
        else
        {
            retVal = retVal + "OFF";
        }

        return retVal;
    }
}