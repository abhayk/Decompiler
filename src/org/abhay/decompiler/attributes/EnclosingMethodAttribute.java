package org.abhay.decompiler.attributes;

/**
 * User: Abhay
 * Date: 3/6/14
 * Time: 11:12 PM
 */
public class EnclosingMethodAttribute extends AbstractAttribute
{
    @Override
    public void parseInfo() throws AttributeException
    {

    }

    @Override
    public String getPrintableString()
    {
        return "Enclosing method attribute found !!";
    }
}
