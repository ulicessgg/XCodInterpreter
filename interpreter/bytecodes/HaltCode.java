package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class HaltCode extends ByteCode
{
    public void init(List<String> s)
    {
    }

    public void execute(VirtualMachine vm)
    {
        vm.setRunning(false);
    }

    public String toString()
    {
        String retVal = "";

        return retVal;
    }
}