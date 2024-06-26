package interpreter.loaders;

import java.util.ArrayList;
import java.util.List;
import interpreter.bytecodes.*;
import java.util.Map;
import java.util.HashMap;

public class Program {

    private List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program()
    {
        program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize()
    {
        return program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter)
    {
        return program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addCode(ByteCode c)
    {
        program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList
     * resolving addrss for Goto,Call and FalseBranch
     * bytecodes. These bytecodes can only jump to Label
     * codes that have a matching label value.
     * HINT: make note of what type of data-structure
     * ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */
    public void resolveAddress() //need to ask about this one for possible suggestions and debugs, past implementation with help didnt work run tests on this using cod files
    {
        Map<String, Integer> labels = new HashMap<>();

        for (int i = 0; i < program.size(); i++)
        {

        }

        for (int j = 0; j < program.size(); j++)
        {
            
        }
    }
}   