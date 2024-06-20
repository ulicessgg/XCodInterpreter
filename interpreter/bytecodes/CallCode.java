package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode
{
    private String label;
    private int address;

    public void init(ArrayList<String> s)
    {
        label = s.getFirst();
    }

    public void execute(VirtualMachine vm)
    {
        vm.pushReturnAddress(vm.getProgramCounter());

        vm.setProgramCounter(address);
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