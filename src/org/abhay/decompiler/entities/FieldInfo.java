package org.abhay.decompiler.entities;

import org.abhay.decompiler.main.Constants;

import java.util.Map;

/**
 * User: Abhay
 * Date: 2/23/14
 * Time: 7:23 PM
 */
public class FieldInfo extends ClassEntity
{
    public FieldInfo(ConstantPool constantPool)
    {
        super(constantPool);
    }

    @Override
    public String getPrintableString()
    {
        StringBuilder fieldStr = new StringBuilder();

        appendModifiers(fieldStr);

        fieldStr.append( getParsedType( descriptor ) ).append(" ");

        fieldStr.append( name );

        fieldStr.append(" ;");

        return fieldStr.toString();
    }

    @Override
    public Map<Integer, String> getModifierMap()
    {
        return Constants.getFieldModifierMap();
    }
}
