package interpreter.loaders;

import interpreter.bytecodes.*;
import interpreter.loaders.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public final class ByteCodeLoader {
    private String codSourceFileName;
    
    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName){
        this.codSourceFileName = fileName;
    }
    
    /**
     * Loads a program from a .cod file.
     * @return a constructed Program Object.
     * @throws InvalidProgramException thrown when 
     * loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException
    {
       Program program = new Program();

       try(BufferedReader reader = new BufferedReader(new FileReader(codSourceFileName)))
       {
           while(reader.ready())
           {
               String line = reader.readLine();
               String[] tokens = line.split("\\s+");
               String byteCodeName = tokens[0];
               String className = CodeTable.getClassName(byteCodeName);
               Class<?> c = Class.forName("interpreter.bytecodes." + className);
               ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();
               bc.init(Arrays.asList(tokens));
               program.addCode(bc);
               //System.out.println(c);
           }
       }

       catch(IOException e)
       {
           throw new InvalidProgramException("Error");
       }

       catch(ClassNotFoundException e)
       {
           throw new RuntimeException(e);
       }

       catch(InvocationTargetException e)
       {
           throw new RuntimeException(e);
       }

       catch(InstantiationException e)
       {
           throw new RuntimeException(e);
       }

       catch(IllegalAccessException e)
       {
           throw new RuntimeException(e);
       }

       catch(NoSuchMethodException e)
       {
           throw new RuntimeException(e);
       }

       return program;
    }
}
