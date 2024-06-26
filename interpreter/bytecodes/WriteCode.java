package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class WriteCode extends ByteCode
{
    public void init(List<String> s)
    {

    }

    public void execute(VirtualMachine vm)
    {
        System.out.println(vm.peek());
    }

    public String toString()
    {
        String retVal = "WRITE ";

        return retVal;
    }
}