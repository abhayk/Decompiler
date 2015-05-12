package org.abhay.decompiler.attributes;

import org.abhay.decompiler.util.ByteArrayIterator;

/**
 * User: Abhay
 * Date: 2/2/14
 * Time: 7:16 PM
 */
public class SignatureAttribute extends AbstractAttribute
{
    private String signatureName;

    @Override
    public void parseInfo()
    {
        System.out.println("Signature attribute found !!");
        ByteArrayIterator iterator = new ByteArrayIterator( info );
        int signatureIndex = iterator.nextUnsignedInt();
        this.signatureName = constantPool.getUtf8Value( signatureIndex );
    }

    @Override
    public String getPrintableString()
    {
        return null;
    }

    public String getSignatureName()
    {
        return signatureName;
    }
}
