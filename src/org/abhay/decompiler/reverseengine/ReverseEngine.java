package org.abhay.decompiler.reverseengine;

import org.abhay.decompiler.attributes.CodeAttribute;

/**
 * User: Abhay
 * Date: 3/16/14
 * Time: 6:16 PM
 */
public interface ReverseEngine
{
    public String process( CodeAttribute codeAttribute );
}
