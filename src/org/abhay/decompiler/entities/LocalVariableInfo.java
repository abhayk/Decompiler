package org.abhay.decompiler.entities;

import org.abhay.decompiler.util.Helper;

/**
 * User: Abhay
 * Date: 2/25/14
 * Time: 12:07 AM
 */
public class LocalVariableInfo
{
    private int startPc;
    private int length;
    private String name;
    private String descriptor;
    private int index;

    private ConstantPool constantPool;

    public LocalVariableInfo( ConstantPool constantPool )
    {
        this.constantPool = constantPool;
    }

    public void setParameters(int startPc, int length, int nameIndex, int descriptorIndex, int index)
    {
        this.startPc = startPc;
        this.length = length;
        this.name = constantPool.getUtf8Value( nameIndex );
        this.descriptor = constantPool.getUtf8Value( descriptorIndex );
        this.index = index;
    }

    public String getPrintableString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( Helper.getParsedType( descriptor ) ).append(" ").append( name );
        return sb.toString();
    }

    public String getName()
    {
        return name;
    }

    public int getIndex()
    {
        return index;
    }
}
