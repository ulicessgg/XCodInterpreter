package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class ReturnCode extends ByteCode
{
    private String label;

    public void init(List<String> s)
    {
        if(!s.isEmpty())
        {
            this.label = s.getFirst();
        }
    }

    public void execute(VirtualMachine vm)
    {
        int value = vm.pop();
        vm.popFrame();
        vm.push(value);

        int address = vm.popReturnAddress();
        vm.setProgramCounter(address);
    }

    public String toString()
    {
        String retVal = "RETURN ";

        if(label != null)
        {
            retVal = retVal + label + " EXIT " + label;
        }

        return retVal;
    }
}