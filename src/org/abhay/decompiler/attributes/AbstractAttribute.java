package org.abhay.decompiler.attributes;

import org.abhay.decompiler.entities.ConstantPool;

/**
 * User: Abhay
 * Date: 3/16/14
 * Time: 6:27 PM
 */
public abstract class AbstractAttribute implements Attribute
{
    public String name;
    public int length;
    public byte[] info;

    public ConstantPool constantPool;

    @Override
    public void setParameters( ConstantPool constantPool, String name, int length, byte[] info ) throws AttributeException
    {
        this.constantPool = constantPool;
        this.name = name;
        this.length = length;
        this.info = info;

        parseInfo();
    }

    @Override
    public String getName()
    {
        return name;
    }
}
