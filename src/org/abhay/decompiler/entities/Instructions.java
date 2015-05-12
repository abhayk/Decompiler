package org.abhay.decompiler.entities;

import org.abhay.decompiler.main.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * User: Abhay
 * Date: 3/15/14
 * Time: 1:38 AM
 */
public class Instructions
{
    private static final Map<Integer, Instruction> opCodeByteCodeMap;

    private Instructions()
    {
    }

    public static Instruction getInstruction( int opCode )
    {
        Instruction instruction = opCodeByteCodeMap.get( opCode );
        if( instruction == null )
            throw new NoSuchElementException( "Undefined opcode found - " + Integer.toHexString( opCode ) );
        return instruction;
    }

    static
    {
        opCodeByteCodeMap = new HashMap<Integer, Instruction>();

        opCodeByteCodeMap.put( 0x0, new Instruction( OpCode.NOP, 0 ) );
        opCodeByteCodeMap.put( 0x1, new Instruction( OpCode.ACONST_NULL, 0 ) );
        opCodeByteCodeMap.put( 0x2, new Instruction( OpCode.ICONST_M1, 0 ) );
        opCodeByteCodeMap.put( 0x3, new Instruction( OpCode.ICONST_0, 0 ) );
        opCodeByteCodeMap.put( 0x4, new Instruction( OpCode.ICONST_1, 0 ) );
        opCodeByteCodeMap.put( 0x5, new Instruction( OpCode.ICONST_2, 0 ) );
        opCodeByteCodeMap.put( 0x6, new Instruction( OpCode.ICONST_3, 0 ) );
        opCodeByteCodeMap.put( 0x7, new Instruction( OpCode.ICONST_4, 0 ) );
        opCodeByteCodeMap.put( 0x8, new Instruction( OpCode.ICONST_5, 0 ) );
        opCodeByteCodeMap.put( 0x9, new Instruction( OpCode.LCONST_0, 0 ) );
        opCodeByteCodeMap.put( 0x0a, new Instruction( OpCode.LCONST_1, 0 ) );
        opCodeByteCodeMap.put( 0x0b, new Instruction( OpCode.FCONST_0, 0 ) );
        opCodeByteCodeMap.put( 0x0c, new Instruction( OpCode.FCONST_1, 0 ) );
        opCodeByteCodeMap.put( 0x0d, new Instruction( OpCode.FCONST_2, 0 ) );
        opCodeByteCodeMap.put( 0x0e, new Instruction( OpCode.DCONST_0, 0 ) );
        opCodeByteCodeMap.put( 0x0f, new Instruction( OpCode.DCONST_1, 0 ) );
        opCodeByteCodeMap.put( 0x10, new Instruction( OpCode.BIPUSH, 1 ) );
        opCodeByteCodeMap.put( 0x11, new Instruction( OpCode.SIPUSH, 2 ) );
        opCodeByteCodeMap.put( 0x12, new Instruction( OpCode.LDC, 1 ) );
        opCodeByteCodeMap.put( 0x13, new Instruction( OpCode.LDC_W, 2 ) );
        opCodeByteCodeMap.put( 0x14, new Instruction( OpCode.LDC2_W, 2 ) );
        opCodeByteCodeMap.put( 0x15, new Instruction( OpCode.ILOAD, 1 ) );
        opCodeByteCodeMap.put( 0x16, new Instruction( OpCode.LLOAD, 1 ) );
        opCodeByteCodeMap.put( 0x17, new Instruction( OpCode.FLOAD, 1 ) );
        opCodeByteCodeMap.put( 0x18, new Instruction( OpCode.DLOAD, 1 ) );
        opCodeByteCodeMap.put( 0x19, new Instruction( OpCode.ALOAD, 1 ) );
        opCodeByteCodeMap.put( 0x1a, new Instruction( OpCode.ILOAD_0, 0 ) );
        opCodeByteCodeMap.put( 0x1b, new Instruction( OpCode.ILOAD_1, 0 ) );
        opCodeByteCodeMap.put( 0x1c, new Instruction( OpCode.ILOAD_2, 0 ) );
        opCodeByteCodeMap.put( 0x1d, new Instruction( OpCode.ILOAD_3, 0 ) );
        opCodeByteCodeMap.put( 0x1e, new Instruction( OpCode.LLOAD_0, 0 ) );
        opCodeByteCodeMap.put( 0x1f, new Instruction( OpCode.LLOAD_1, 0 ) );
        opCodeByteCodeMap.put( 0x20, new Instruction( OpCode.LLOAD_2, 0 ) );
        opCodeByteCodeMap.put( 0x21, new Instruction( OpCode.LLOAD_3, 0 ) );
        opCodeByteCodeMap.put( 0x22, new Instruction( OpCode.FLOAD_0, 0 ) );
        opCodeByteCodeMap.put( 0x23, new Instruction( OpCode.FLOAD_1, 0 ) );
        opCodeByteCodeMap.put( 0x24, new Instruction( OpCode.FLOAD_2, 0 ) );
        opCodeByteCodeMap.put( 0x25, new Instruction( OpCode.FLOAD_3, 0 ) );
        opCodeByteCodeMap.put( 0x26, new Instruction( OpCode.DLOAD_0, 0 ) );
        opCodeByteCodeMap.put( 0x27, new Instruction( OpCode.DLOAD_1, 0 ) );
        opCodeByteCodeMap.put( 0x28, new Instruction( OpCode.DLOAD_2, 0 ) );
        opCodeByteCodeMap.put( 0x29, new Instruction( OpCode.DLOAD_3, 0 ) );
        opCodeByteCodeMap.put( 0x2a, new Instruction( OpCode.ALOAD_0, 0 ) );
        opCodeByteCodeMap.put( 0x2b, new Instruction( OpCode.ALOAD_1, 0 ) );
        opCodeByteCodeMap.put( 0x2c, new Instruction( OpCode.ALOAD_2, 0 ) );
        opCodeByteCodeMap.put( 0x2d, new Instruction( OpCode.ALOAD_3, 0 ) );
        opCodeByteCodeMap.put( 0x2e, new Instruction( OpCode.IALOAD, 0 ) );
        opCodeByteCodeMap.put( 0x2f, new Instruction( OpCode.LALOAD, 0 ) );
        opCodeByteCodeMap.put( 0x30, new Instruction( OpCode.FALOAD, 0 ) );
        opCodeByteCodeMap.put( 0x31, new Instruction( OpCode.DALOAD, 0 ) );
        opCodeByteCodeMap.put( 0x32, new Instruction( OpCode.AALOAD, 0 ) );
        opCodeByteCodeMap.put( 0x33, new Instruction( OpCode.BALOAD, 0 ) );
        opCodeByteCodeMap.put( 0x34, new Instruction( OpCode.CALOAD, 0 ) );
        opCodeByteCodeMap.put( 0x35, new Instruction( OpCode.SALOAD, 0 ) );
        opCodeByteCodeMap.put( 0x36, new Instruction( OpCode.ISTORE, 1 ) );
        opCodeByteCodeMap.put( 0x37, new Instruction( OpCode.LSTORE, 1 ) );
        opCodeByteCodeMap.put( 0x38, new Instruction( OpCode.FSTORE, 1 ) );
        opCodeByteCodeMap.put( 0x39, new Instruction( OpCode.DSTORE, 1 ) );
        opCodeByteCodeMap.put( 0x3a, new Instruction( OpCode.ASTORE, 1 ) );
        opCodeByteCodeMap.put( 0x3b, new Instruction( OpCode.ISTORE_0, 0 ) );
        opCodeByteCodeMap.put( 0x3c, new Instruction( OpCode.ISTORE_1, 0 ) );
        opCodeByteCodeMap.put( 0x3d, new Instruction( OpCode.ISTORE_2, 0 ) );
        opCodeByteCodeMap.put( 0x3e, new Instruction( OpCode.ISTORE_3, 0 ) );
        opCodeByteCodeMap.put( 0x3f, new Instruction( OpCode.LSTORE_0, 0 ) );
        opCodeByteCodeMap.put( 0x40, new Instruction( OpCode.LSTORE_1, 0 ) );
        opCodeByteCodeMap.put( 0x41, new Instruction( OpCode.LSTORE_2, 0 ) );
        opCodeByteCodeMap.put( 0x42, new Instruction( OpCode.LSTORE_3, 0 ) );
        opCodeByteCodeMap.put( 0x43, new Instruction( OpCode.FSTORE_0, 0 ) );
        opCodeByteCodeMap.put( 0x44, new Instruction( OpCode.FSTORE_1, 0 ) );
        opCodeByteCodeMap.put( 0x45, new Instruction( OpCode.FSTORE_2, 0 ) );
        opCodeByteCodeMap.put( 0x46, new Instruction( OpCode.FSTORE_3, 0 ) );
        opCodeByteCodeMap.put( 0x47, new Instruction( OpCode.DSTORE_0, 0 ) );
        opCodeByteCodeMap.put( 0x48, new Instruction( OpCode.DSTORE_1, 0 ) );
        opCodeByteCodeMap.put( 0x49, new Instruction( OpCode.DSTORE_2, 0 ) );
        opCodeByteCodeMap.put( 0x4a, new Instruction( OpCode.DSTORE_3, 0 ) );
        opCodeByteCodeMap.put( 0x4b, new Instruction( OpCode.ASTORE_0, 0 ) );
        opCodeByteCodeMap.put( 0x4c, new Instruction( OpCode.ASTORE_1, 0 ) );
        opCodeByteCodeMap.put( 0x4d, new Instruction( OpCode.ASTORE_2, 0 ) );
        opCodeByteCodeMap.put( 0x4e, new Instruction( OpCode.ASTORE_3, 0 ) );
        opCodeByteCodeMap.put( 0x4f, new Instruction( OpCode.IASTORE, 0 ) );
        opCodeByteCodeMap.put( 0x50, new Instruction( OpCode.LASTORE, 0 ) );
        opCodeByteCodeMap.put( 0x51, new Instruction( OpCode.FASTORE, 0 ) );
        opCodeByteCodeMap.put( 0x52, new Instruction( OpCode.DASTORE, 0 ) );
        opCodeByteCodeMap.put( 0x53, new Instruction( OpCode.AASTORE, 0 ) );
        opCodeByteCodeMap.put( 0x54, new Instruction( OpCode.BASTORE, 0 ) );
        opCodeByteCodeMap.put( 0x55, new Instruction( OpCode.CASTORE, 0 ) );
        opCodeByteCodeMap.put( 0x56, new Instruction( OpCode.SASTORE, 0 ) );
        opCodeByteCodeMap.put( 0x57, new Instruction( OpCode.POP, 0 ) );
        opCodeByteCodeMap.put( 0x58, new Instruction( OpCode.POP2, 0 ) );
        opCodeByteCodeMap.put( 0x59, new Instruction( OpCode.DUP, 0 ) );
        opCodeByteCodeMap.put( 0x5a, new Instruction( OpCode.DUP_X1, 0 ) );
        opCodeByteCodeMap.put( 0x5b, new Instruction( OpCode.DUP_X2, 0 ) );
        opCodeByteCodeMap.put( 0x5c, new Instruction( OpCode.DUP2, 0 ) );
        opCodeByteCodeMap.put( 0x5d, new Instruction( OpCode.DUP2_X1, 0 ) );
        opCodeByteCodeMap.put( 0x5e, new Instruction( OpCode.DUP2_X2, 0 ) );
        opCodeByteCodeMap.put( 0x5f, new Instruction( OpCode.SWAP, 0 ) );
        opCodeByteCodeMap.put( 0x60, new Instruction( OpCode.IADD, 0 ) );
        opCodeByteCodeMap.put( 0x61, new Instruction( OpCode.LADD, 0 ) );
        opCodeByteCodeMap.put( 0x62, new Instruction( OpCode.FADD, 0 ) );
        opCodeByteCodeMap.put( 0x63, new Instruction( OpCode.DADD, 0 ) );
        opCodeByteCodeMap.put( 0x64, new Instruction( OpCode.ISUB, 0 ) );
        opCodeByteCodeMap.put( 0x65, new Instruction( OpCode.LSUB, 0 ) );
        opCodeByteCodeMap.put( 0x66, new Instruction( OpCode.FSUB, 0 ) );
        opCodeByteCodeMap.put( 0x67, new Instruction( OpCode.DSUB, 0 ) );
        opCodeByteCodeMap.put( 0x68, new Instruction( OpCode.IMUL, 0 ) );
        opCodeByteCodeMap.put( 0x69, new Instruction( OpCode.LMUL, 0 ) );
        opCodeByteCodeMap.put( 0x6a, new Instruction( OpCode.FMUL, 0 ) );
        opCodeByteCodeMap.put( 0x6b, new Instruction( OpCode.DMUL, 0 ) );
        opCodeByteCodeMap.put( 0x6c, new Instruction( OpCode.IDIV, 0 ) );
        opCodeByteCodeMap.put( 0x6d, new Instruction( OpCode.LDIV, 0 ) );
        opCodeByteCodeMap.put( 0x6e, new Instruction( OpCode.FDIV, 0 ) );
        opCodeByteCodeMap.put( 0x6f, new Instruction( OpCode.DDIV, 0 ) );
        opCodeByteCodeMap.put( 0x70, new Instruction( OpCode.IREM, 0 ) );
        opCodeByteCodeMap.put( 0x71, new Instruction( OpCode.LREM, 0 ) );
        opCodeByteCodeMap.put( 0x72, new Instruction( OpCode.FREM, 0 ) );
        opCodeByteCodeMap.put( 0x73, new Instruction( OpCode.DREM, 0 ) );
        opCodeByteCodeMap.put( 0x74, new Instruction( OpCode.INEG, 0 ) );
        opCodeByteCodeMap.put( 0x75, new Instruction( OpCode.LNEG, 0 ) );
        opCodeByteCodeMap.put( 0x76, new Instruction( OpCode.FNEG, 0 ) );
        opCodeByteCodeMap.put( 0x77, new Instruction( OpCode.DNEG, 0 ) );
        opCodeByteCodeMap.put( 0x78, new Instruction( OpCode.ISHL, 0 ) );
        opCodeByteCodeMap.put( 0x79, new Instruction( OpCode.LSHL, 0 ) );
        opCodeByteCodeMap.put( 0x7a, new Instruction( OpCode.ISHR, 0 ) );
        opCodeByteCodeMap.put( 0x7b, new Instruction( OpCode.LSHR, 0 ) );
        opCodeByteCodeMap.put( 0x7c, new Instruction( OpCode.IUSHR, 0 ) );
        opCodeByteCodeMap.put( 0x7d, new Instruction( OpCode.LUSHR, 0 ) );
        opCodeByteCodeMap.put( 0x7e, new Instruction( OpCode.IAND, 0 ) );
        opCodeByteCodeMap.put( 0x7f, new Instruction( OpCode.LAND, 0 ) );
        opCodeByteCodeMap.put( 0x80, new Instruction( OpCode.IOR, 0 ) );
        opCodeByteCodeMap.put( 0x81, new Instruction( OpCode.LOR, 0 ) );
        opCodeByteCodeMap.put( 0x82, new Instruction( OpCode.IXOR, 0 ) );
        opCodeByteCodeMap.put( 0x83, new Instruction( OpCode.LXOR, 0 ) );
        opCodeByteCodeMap.put( 0x84, new Instruction( OpCode.IINC, 2 ) );
        opCodeByteCodeMap.put( 0x85, new Instruction( OpCode.I2L, 0 ) );
        opCodeByteCodeMap.put( 0x86, new Instruction( OpCode.I2F, 0 ) );
        opCodeByteCodeMap.put( 0x87, new Instruction( OpCode.I2D, 0 ) );
        opCodeByteCodeMap.put( 0x88, new Instruction( OpCode.L2I, 0 ) );
        opCodeByteCodeMap.put( 0x89, new Instruction( OpCode.L2F, 0 ) );
        opCodeByteCodeMap.put( 0x8a, new Instruction( OpCode.L2D, 0 ) );
        opCodeByteCodeMap.put( 0x8b, new Instruction( OpCode.F2I, 0 ) );
        opCodeByteCodeMap.put( 0x8c, new Instruction( OpCode.F2L, 0 ) );
        opCodeByteCodeMap.put( 0x8d, new Instruction( OpCode.F2D, 0 ) );
        opCodeByteCodeMap.put( 0x8e, new Instruction( OpCode.D2I, 0 ) );
        opCodeByteCodeMap.put( 0x8f, new Instruction( OpCode.D2L, 0 ) );
        opCodeByteCodeMap.put( 0x90, new Instruction( OpCode.D2F, 0 ) );
        opCodeByteCodeMap.put( 0x91, new Instruction( OpCode.I2B, 0 ) );
        opCodeByteCodeMap.put( 0x92, new Instruction( OpCode.I2C, 0 ) );
        opCodeByteCodeMap.put( 0x93, new Instruction( OpCode.I2S, 0 ) );
        opCodeByteCodeMap.put( 0x94, new Instruction( OpCode.LCMP, 0 ) );
        opCodeByteCodeMap.put( 0x95, new Instruction( OpCode.FCMPL, 0 ) );
        opCodeByteCodeMap.put( 0x96, new Instruction( OpCode.FCMPG, 0 ) );
        opCodeByteCodeMap.put( 0x97, new Instruction( OpCode.DCMPL, 0 ) );
        opCodeByteCodeMap.put( 0x98, new Instruction( OpCode.DCMPG, 0 ) );
        opCodeByteCodeMap.put( 0x99, new Instruction( OpCode.IFEQ, 2 ) );
        opCodeByteCodeMap.put( 0x9a, new Instruction( OpCode.IFNE, 2 ) );
        opCodeByteCodeMap.put( 0x9b, new Instruction( OpCode.IFLT, 2 ) );
        opCodeByteCodeMap.put( 0x9c, new Instruction( OpCode.IFGE, 2 ) );
        opCodeByteCodeMap.put( 0x9d, new Instruction( OpCode.IFGT, 2 ) );
        opCodeByteCodeMap.put( 0x9e, new Instruction( OpCode.IFLE, 2 ) );
        opCodeByteCodeMap.put( 0x9f, new Instruction( OpCode.IF_ICMPEQ, 2 ) );
        opCodeByteCodeMap.put( 0xa0, new Instruction( OpCode.IF_ICMPNE, 2 ) );
        opCodeByteCodeMap.put( 0xa1, new Instruction( OpCode.IF_ICMPLT, 2 ) );
        opCodeByteCodeMap.put( 0xa2, new Instruction( OpCode.IF_ICMPGE, 2 ) );
        opCodeByteCodeMap.put( 0xa3, new Instruction( OpCode.IF_ICMPGT, 2 ) );
        opCodeByteCodeMap.put( 0xa4, new Instruction( OpCode.IF_ICMPLE, 2 ) );
        opCodeByteCodeMap.put( 0xa5, new Instruction( OpCode.IF_ACMPEQ, 2 ) );
        opCodeByteCodeMap.put( 0xa6, new Instruction( OpCode.IF_ACMPNE, 2 ) );
        opCodeByteCodeMap.put( 0xa7, new Instruction( OpCode.GOTO, 2 ) );
        opCodeByteCodeMap.put( 0xa8, new Instruction( OpCode.JSR, 2 ) );
        opCodeByteCodeMap.put( 0xa9, new Instruction( OpCode.RET, 1 ) );
        opCodeByteCodeMap.put( 0xaa, new Instruction( OpCode.TABLESWITCH, Constants.VARIABLE_BYTES ) );
        opCodeByteCodeMap.put( 0xab, new Instruction( OpCode.LOOKUPSWITCH, Constants.VARIABLE_BYTES ) );
        opCodeByteCodeMap.put( 0xac, new Instruction( OpCode.IRETURN, 0 ) );
        opCodeByteCodeMap.put( 0xad, new Instruction( OpCode.LRETURN, 0 ) );
        opCodeByteCodeMap.put( 0xae, new Instruction( OpCode.FRETURN, 0 ) );
        opCodeByteCodeMap.put( 0xaf, new Instruction( OpCode.DRETURN, 0 ) );
        opCodeByteCodeMap.put( 0xb0, new Instruction( OpCode.ARETURN, 0 ) );
        opCodeByteCodeMap.put( 0xb1, new Instruction( OpCode.RETURN, 0 ) );
        opCodeByteCodeMap.put( 0xb2, new Instruction( OpCode.GETSTATIC, 2 ) );
        opCodeByteCodeMap.put( 0xb3, new Instruction( OpCode.PUTSTATIC, 2 ) );
        opCodeByteCodeMap.put( 0xb4, new Instruction( OpCode.GETFIELD, 2 ) );
        opCodeByteCodeMap.put( 0xb5, new Instruction( OpCode.PUTFIELD, 2 ) );
        opCodeByteCodeMap.put( 0xb6, new Instruction( OpCode.INVOKEVIRTUAL, 2 ) );
        opCodeByteCodeMap.put( 0xb7, new Instruction( OpCode.INVOKESPECIAL, 2 ) );
        opCodeByteCodeMap.put( 0xb8, new Instruction( OpCode.INVOKESTATIC, 2 ) );
        opCodeByteCodeMap.put( 0xb9, new Instruction( OpCode.INVOKEINTERFACE, 4 ) );
        opCodeByteCodeMap.put( 0xba, new Instruction( OpCode.INVOKEDYNAMIC, 4 ) );
        opCodeByteCodeMap.put( 0xbb, new Instruction( OpCode.NEW, 2 ) );
        opCodeByteCodeMap.put( 0xbc, new Instruction( OpCode.NEWARRAY, 1 ) );
        opCodeByteCodeMap.put( 0xbd, new Instruction( OpCode.ANEWARRAY, 2 ) );
        opCodeByteCodeMap.put( 0xbe, new Instruction( OpCode.ARRAYLENGTH, 0 ) );
        opCodeByteCodeMap.put( 0xbf, new Instruction( OpCode.ATHROW, 0 ) );
        opCodeByteCodeMap.put( 0xc0, new Instruction( OpCode.CHECKCAST, 2 ) );
        opCodeByteCodeMap.put( 0xc1, new Instruction( OpCode.INSTANCEOF, 2 ) );
        opCodeByteCodeMap.put( 0xc2, new Instruction( OpCode.MONITORENTER, 0 ) );
        opCodeByteCodeMap.put( 0xc3, new Instruction( OpCode.MONITOREXIT, 0 ) );
        opCodeByteCodeMap.put( 0xc4, new Instruction( OpCode.WIDE, Constants.VARIABLE_BYTES ) );
        opCodeByteCodeMap.put( 0xc5, new Instruction( OpCode.MULTIANEWARRAY, 3 ) );
        opCodeByteCodeMap.put( 0xc6, new Instruction( OpCode.IFNULL, 2 ) );
        opCodeByteCodeMap.put( 0xc7, new Instruction( OpCode.IFNONNULL, 2 ) );
        opCodeByteCodeMap.put( 0xc8, new Instruction( OpCode.GOTO_W, 4 ) );
        opCodeByteCodeMap.put( 0xc9, new Instruction( OpCode.JSR_W, 4 ) );
    }
}
