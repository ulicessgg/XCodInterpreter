package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode
{
    public void init(List<String> s)
    {
    }

    public void execute(VirtualMachine vm)
    {
        Scanner input = new Scanner(System.in);
        int value = 0;
        boolean valid = false;

        while(!valid)
        {
            System.out.println("Please enter an integer: ");
            if(input.hasNextInt())
            {
                value = input.nextInt();
                valid = true;
            }
            else
            {
                System.out.println("Integer is invalid!");
                input.next();
            }
        }
        vm.push(value);
    }

    public String toString()
    {
        String retVal = "READ ";

        return retVal;
    }
}