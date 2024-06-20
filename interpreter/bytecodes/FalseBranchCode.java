package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode
{
    private String label;
    private int address;
    public void init(ArrayList<String> s)
    {
        label = s.getFirst();
    }

    public void execute(VirtualMachine vm)
    {
        int poppedValue = vm.pop();

        if(poppedValue == 0)
        {
            vm.setProgramCounter(address);
        }
    }

    public void setAddress(int address)
    {
        this.address = address;
    }

    public String getLabel()
    {
        return label;
    }
}