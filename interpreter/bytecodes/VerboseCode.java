package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class VerboseCode extends ByteCode
{
    private boolean value;

    public void init(List<String> s)
    {
    }

    public void execute(VirtualMachine vm)
    {
        if(vm.getVerboseMode())
        {
            this.value = false;
        }
        if(!vm.getVerboseMode())
        {
            this.value = true;
        }
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