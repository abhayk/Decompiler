package org.abhay.decompiler.attributes;

/**
 * User: Abhay
 * Date: 2/2/14
 * Time: 7:19 PM
 */
public class SyntheticAttribute extends AbstractAttribute
{
    @Override
    public void parseInfo()
    {
        System.out.println("Synthetic attribute found !!");
    }

    @Override
    public String getPrintableString()
    {
        return null;
    }
}
