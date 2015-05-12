package org.abhay.decompiler.attributes;

import org.abhay.decompiler.entities.ConstantPool;

/**
 * User: Abhay
 * Date: 2/2/14
 * Time: 6:23 PM
 */
public interface Attribute
{
    public void parseInfo() throws AttributeException;

    public String getPrintableString();

    public String getName();

    public void setParameters( ConstantPool constantPool, String name, int length, byte[] info ) throws AttributeException;
}
