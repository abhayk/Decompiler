package org.abhay.decompiler.attributes;

/**
 * User: Abhay
 * Date: 2/27/14
 * Time: 4:02 PM
 */
public class AttributeException extends Exception
{
    public AttributeException( String message, String attributeName )
    {
        super( message + " - " + attributeName);
    }

    public AttributeException( String message, String attributeName, Throwable e)
    {
        super( message + " - " + attributeName, e);
    }

}
