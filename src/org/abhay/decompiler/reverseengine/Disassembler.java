package org.abhay.decompiler.reverseengine;

import org.abhay.decompiler.attributes.CodeAttribute;
import org.abhay.decompiler.entities.Instruction;
import org.abhay.decompiler.util.ByteArrayIterator;

/**
 * User: Abhay
 * Date: 3/16/14
 * Time: 6:25 PM
 */
public class Disassembler extends AbstractReverseEngine
{
    @Override
    public String process(CodeAttribute codeAttribute)
    {
        printer.openBrace();

        ByteArrayIterator iterator = new ByteArrayIterator( codeAttribute.getCodeArray() );

        while( iterator.hasNext() )
        {
            int pc = iterator.getCurrentPosition();

            Instruction instruction = getInstruction( iterator );

            printer.printLine( pc + " : " + instruction.getPrintableString());
        }

        printer.closeBrace();

        return printer.get();
    }
}
