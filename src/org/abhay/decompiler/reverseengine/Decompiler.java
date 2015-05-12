package org.abhay.decompiler.reverseengine;

import org.abhay.decompiler.attributes.CodeAttribute;
import org.abhay.decompiler.entities.Instruction;
import org.abhay.decompiler.entities.LocalVariableInfo;
import org.abhay.decompiler.util.ByteArrayIterator;

/**
 * User: Abhay
 * Date: 3/1/14
 * Time: 10:22 AM
 */
public class Decompiler extends AbstractReverseEngine
{
    private LocalVariableInfo[] localVariableInfos;
    private Object[] locals;
    private Stack operandStack;
    private Stack branchStack;
    private Stack gotoStack;

    private void store( int index )
    {
        StringBuilder code = new StringBuilder();

        if( locals[ index ] == null )
            code.append(localVariableInfos[index].getPrintableString());
        else
            code.append(localVariableInfos[index].getName());

        code.append(" = ");

        Object val = operandStack.pop();

        code.append( val ).append(";");

        locals[ index ] = val;

        printer.printLine( code );
    }

    private void branch( String operator, int current, int offset )
    {
        Object val1 = operandStack.pop();
        Object val2 = operandStack.pop();

        branchStack.push( current + offset );

        StringBuilder sb = new StringBuilder();

        if( gotoStack.size() > 0)
        {
            gotoStack.pop();
            sb.append("else ");
        }

        sb.append("if").append("( ").append( val2 ).append(" ").append( operator ).append(" ").append(val1).append(" )");

        printer.printLine(sb);
        printer.openBrace();
    }

    private <T> void load( int index, Class<T> type )
    {
        T val = (T) locals[ index ];
        operandStack.push( val );
    }

    private void load( int index )
    {
        operandStack.push( localVariableInfos[ index ] );
    }

    @Override
    public String process(CodeAttribute codeAttribute)
    {
        printer.openBrace();

        int maxStack = codeAttribute.getMaxStack();

        operandStack = new Stack( maxStack, false );

        branchStack = new Stack( 10, true );

        gotoStack = new Stack( 10, true );

        int maxLocals = codeAttribute.getMaxLocals();

        locals = new Object[ maxLocals ];

        localVariableInfos = codeAttribute.getLocalVariableTableAttribute().getLocalVariableInfos();

        ByteArrayIterator iterator = new ByteArrayIterator( codeAttribute.getCodeArray() );

        while( iterator.hasNext() )
        {
            Instruction instruction = getInstruction( iterator );

            while( branchStack.size() > 0 && iterator.getCurrentPosition() == branchStack.peekInt() )
            {
                printer.closeBrace();
                branchStack.pop();
            }

            switch ( instruction.getOpCode() )
            {
                case NOP:
                {
                    break;
                }
                case ACONST_NULL:
                {
                    break;
                }
                case ICONST_M1:
                {
                    operandStack.push( -1 );
                    break;
                }
                case ICONST_0:
                {
                    operandStack.push( 0 );
                    break;
                }
                case ICONST_1:
                {
                    operandStack.push( 1 );
                    break;
                }
                case ICONST_2:
                {
                    operandStack.push( 2 );
                    break;
                }
                case ICONST_3:
                {
                    operandStack.push( 3 );
                    break;
                }
                case ICONST_4:
                {
                    operandStack.push( 4 );
                    break;
                }
                case ICONST_5:
                {
                    operandStack.push( 5 );
                    break;
                }
                case LCONST_0:
                {
                    break;
                }
                case LCONST_1:
                {
                    break;
                }
                case FCONST_0:
                {
                    break;
                }
                case FCONST_1:
                {
                    break;
                }
                case FCONST_2:
                {
                    break;
                }
                case DCONST_0:
                {
                    break;
                }
                case DCONST_1:
                {
                    break;
                }
                case BIPUSH:
                {
                    operandStack.push( (int) instruction.getOtherBytes()[0]);
                    break;
                }
                case SIPUSH:
                {
                    break;
                }
                case LDC:
                {
                    break;
                }
                case LDC_W:
                {
                    break;
                }
                case LDC2_W:
                {
                    break;
                }
                case ILOAD:
                {
                    break;
                }
                case LLOAD:
                {
                    break;
                }
                case FLOAD:
                {
                    break;
                }
                case DLOAD:
                {
                    break;
                }
                case ALOAD:
                {
                    break;
                }
                case ILOAD_0:
                {
                    load( 0 );
                    break;
                }
                case ILOAD_1:
                {
                    load( 1 );
                    break;
                }
                case ILOAD_2:
                {
                    load( 2 );
                    break;
                }
                case ILOAD_3:
                {
                    load( 3 );
                    break;
                }
                case LLOAD_0:
                {
                    break;
                }
                case LLOAD_1:
                {
                    break;
                }
                case LLOAD_2:
                {
                    break;
                }
                case LLOAD_3:
                {
                    break;
                }
                case FLOAD_0:
                {
                    break;
                }
                case FLOAD_1:
                {
                    break;
                }
                case FLOAD_2:
                {
                    break;
                }
                case FLOAD_3:
                {
                    break;
                }
                case DLOAD_0:
                {
                    break;
                }
                case DLOAD_1:
                {
                    break;
                }
                case DLOAD_2:
                {
                    break;
                }
                case DLOAD_3:
                {
                    break;
                }
                case ALOAD_0:
                {
                    break;
                }
                case ALOAD_1:
                {
                    break;
                }
                case ALOAD_2:
                {
                    break;
                }
                case ALOAD_3:
                {
                    break;
                }
                case IALOAD:
                {
                    break;
                }
                case LALOAD:
                {
                    break;
                }
                case FALOAD:
                {
                    break;
                }
                case DALOAD:
                {
                    break;
                }
                case AALOAD:
                {
                    break;
                }
                case BALOAD:
                {
                    break;
                }
                case CALOAD:
                {
                    break;
                }
                case SALOAD:
                {
                    break;
                }
                case ISTORE:
                {
                    break;
                }
                case LSTORE:
                {
                    break;
                }
                case FSTORE:
                {
                    break;
                }
                case DSTORE:
                {
                    break;
                }
                case ASTORE:
                {
                    break;
                }
                case ISTORE_0:
                {
                    store( 0 );
                    break;
                }
                case ISTORE_1:
                {
                    store( 1 );
                    break;
                }
                case ISTORE_2:
                {
                    store( 2 );
                    break;
                }
                case ISTORE_3:
                {
                    store( 3 );
                    break;
                }
                case LSTORE_0:
                {
                    break;
                }
                case LSTORE_1:
                {
                    break;
                }
                case LSTORE_2:
                {
                    break;
                }
                case LSTORE_3:
                {
                    break;
                }
                case FSTORE_0:
                {
                    break;
                }
                case FSTORE_1:
                {
                    break;
                }
                case FSTORE_2:
                {
                    break;
                }
                case FSTORE_3:
                {
                    break;
                }
                case DSTORE_0:
                {
                    break;
                }
                case DSTORE_1:
                {
                    break;
                }
                case DSTORE_2:
                {
                    break;
                }
                case DSTORE_3:
                {
                    break;
                }
                case ASTORE_0:
                {
                    break;
                }
                case ASTORE_1:
                {
                    break;
                }
                case ASTORE_2:
                {
                    break;
                }
                case ASTORE_3:
                {
                    break;
                }
                case IASTORE:
                {
                    break;
                }
                case LASTORE:
                {
                    break;
                }
                case FASTORE:
                {
                    break;
                }
                case DASTORE:
                {
                    break;
                }
                case AASTORE:
                {
                    break;
                }
                case BASTORE:
                {
                    break;
                }
                case CASTORE:
                {
                    break;
                }
                case SASTORE:
                {
                    break;
                }
                case POP:
                {
                    break;
                }
                case POP2:
                {
                    break;
                }
                case DUP:
                {
                    break;
                }
                case DUP_X1:
                {
                    break;
                }
                case DUP_X2:
                {
                    break;
                }
                case DUP2:
                {
                    break;
                }
                case DUP2_X1:
                {
                    break;
                }
                case DUP2_X2:
                {
                    break;
                }
                case SWAP:
                {
                    break;
                }
                case IADD:
                {
                    Object val1 = operandStack.pop();
                    Object val2 = operandStack.pop();
                    StringBuilder tmp = new StringBuilder();
                    tmp.append( val2 ).append(" + ").append(val1);
                    operandStack.push( tmp );
                    break;
                }
                case LADD:
                {
                    break;
                }
                case FADD:
                {
                    break;
                }
                case DADD:
                {
                    break;
                }
                case ISUB:
                {
                    break;
                }
                case LSUB:
                {
                    break;
                }
                case FSUB:
                {
                    break;
                }
                case DSUB:
                {
                    break;
                }
                case IMUL:
                {
                    break;
                }
                case LMUL:
                {
                    break;
                }
                case FMUL:
                {
                    break;
                }
                case DMUL:
                {
                    break;
                }
                case IDIV:
                {
                    break;
                }
                case LDIV:
                {
                    break;
                }
                case FDIV:
                {
                    break;
                }
                case DDIV:
                {
                    break;
                }
                case IREM:
                {
                    break;
                }
                case LREM:
                {
                    break;
                }
                case FREM:
                {
                    break;
                }
                case DREM:
                {
                    break;
                }
                case INEG:
                {
                    break;
                }
                case LNEG:
                {
                    break;
                }
                case FNEG:
                {
                    break;
                }
                case DNEG:
                {
                    break;
                }
                case ISHL:
                {
                    break;
                }
                case LSHL:
                {
                    break;
                }
                case ISHR:
                {
                    break;
                }
                case LSHR:
                {
                    break;
                }
                case IUSHR:
                {
                    break;
                }
                case LUSHR:
                {
                    break;
                }
                case IAND:
                {
                    break;
                }
                case LAND:
                {
                    break;
                }
                case IOR:
                {
                    break;
                }
                case LOR:
                {
                    break;
                }
                case IXOR:
                {
                    break;
                }
                case LXOR:
                {
                    break;
                }
                case IINC:
                {
                    break;
                }
                case I2L:
                {
                    break;
                }
                case I2F:
                {
                    break;
                }
                case I2D:
                {
                    break;
                }
                case L2I:
                {
                    break;
                }
                case L2F:
                {
                    break;
                }
                case L2D:
                {
                    break;
                }
                case F2I:
                {
                    break;
                }
                case F2L:
                {
                    break;
                }
                case F2D:
                {
                    break;
                }
                case D2I:
                {
                    break;
                }
                case D2L:
                {
                    break;
                }
                case D2F:
                {
                    break;
                }
                case I2B:
                {
                    break;
                }
                case I2C:
                {
                    break;
                }
                case I2S:
                {
                    break;
                }
                case LCMP:
                {
                    break;
                }
                case FCMPL:
                {
                    break;
                }
                case FCMPG:
                {
                    break;
                }
                case DCMPL:
                {
                    break;
                }
                case DCMPG:
                {
                    break;
                }
                case IFEQ:
                {
                    break;
                }
                case IFNE:
                {
                    break;
                }
                case IFLT:
                {
                    break;
                }
                case IFGE:
                {
                    break;
                }
                case IFGT:
                {
                    break;
                }
                case IFLE:
                {
                    break;
                }
                case IF_ICMPEQ:
                {
                    break;
                }
                case IF_ICMPNE:
                {
                    break;
                }
                case IF_ICMPLT:
                {
                    break;
                }
                case IF_ICMPGE:
                {
                    break;
                }
                case IF_ICMPGT:
                {
                    break;
                }
                case IF_ICMPLE:
                {
                    branch( ">", iterator.getCurrentPosition(), instruction.getOffset() );
                    break;
                }
                case IF_ACMPEQ:
                {
                    break;
                }
                case IF_ACMPNE:
                {
                    break;
                }
                case GOTO:
                {
                    branchStack.pop();
                    printer.closeBrace();
                    gotoStack.push( iterator.getCurrentPosition() + instruction.getOffset() );
                    break;
                }
                case JSR:
                {
                    break;
                }
                case RET:
                {
                    break;
                }
                case TABLESWITCH:
                {
                    break;
                }
                case LOOKUPSWITCH:
                {
                    break;
                }
                case IRETURN:
                {
                    break;
                }
                case LRETURN:
                {
                    break;
                }
                case FRETURN:
                {
                    break;
                }
                case DRETURN:
                {
                    break;
                }
                case ARETURN:
                {
                    break;
                }
                case RETURN:
                {
                    break;
                }
                case GETSTATIC:
                {
                    break;
                }
                case PUTSTATIC:
                {
                    break;
                }
                case GETFIELD:
                {
                    break;
                }
                case PUTFIELD:
                {
                    break;
                }
                case INVOKEVIRTUAL:
                {
                    break;
                }
                case INVOKESPECIAL:
                {
                    break;
                }
                case INVOKESTATIC:
                {
                    break;
                }
                case INVOKEINTERFACE:
                {
                    break;
                }
                case INVOKEDYNAMIC:
                {
                    break;
                }
                case NEW:
                {
                    break;
                }
                case NEWARRAY:
                {
                    break;
                }
                case ANEWARRAY:
                {
                    break;
                }
                case ARRAYLENGTH:
                {
                    break;
                }
                case ATHROW:
                {
                    break;
                }
                case CHECKCAST:
                {
                    break;
                }
                case INSTANCEOF:
                {
                    break;
                }
                case MONITORENTER:
                {
                    break;
                }
                case MONITOREXIT:
                {
                    break;
                }
                case WIDE:
                {
                    break;
                }
                case MULTIANEWARRAY:
                {
                    break;
                }
                case IFNULL:
                {
                    break;
                }
                case IFNONNULL:
                {
                    break;
                }
                case GOTO_W:
                {
                    break;
                }
                case JSR_W:
                {
                    break;
                }
            }
        }
        printer.closeBrace();
        return printer.get();
    }

}
