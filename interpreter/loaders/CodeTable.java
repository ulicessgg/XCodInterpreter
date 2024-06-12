/**
 * Code table of byte codes in language X
 * @key name of a specific byte code
 * @value name of the class that the key belongs to.
 */
package interpreter.loaders;

import java.util.HashMap;
import java.util.Map;

public final class CodeTable {

   private CodeTable() {
      // do nothing
   }

   private static Map<String, String> codeTable = new HashMap<>();

   /**
    * fill code table with class name mappings
    */
   public static void init()
   {
      codeTable.put("HALT", "HaltCode");
      codeTable.put("POP", "PopCode");
      codeTable.put("FALSEBRANCH", "FalseBranchCode");
      codeTable.put("GOTO", "GoToCode");
      codeTable.put("STORE", "StoreCode");
      codeTable.put("LOAD", "LoadCode");
      codeTable.put("LIT", "LitCode");
      codeTable.put("ARGS", "ArgsCode");
      codeTable.put("CALL", "CallCode");
      codeTable.put("RETURN", "ReturnCode");
      codeTable.put("BOP", "BopCode");
      codeTable.put("READ", "ReadCode");
      codeTable.put("WRITE", "WriteCode");
      codeTable.put("LABEL", "LabelCode");
      codeTable.put("VERBOSE", "VerboseCode");
   }

   /**
    * Returns the ByteCode class name for a given token.
    * 
    * @param token bytecode to map. For example, HALT --> HaltCode
    * @return class name of bytecode
    */
   public static String getClassName(String token)
   {
      return codeTable.get(token);
   }

}
