package org.abhay.decompiler.entities;

import org.abhay.decompiler.attributes.Attribute;
import org.abhay.decompiler.util.Helper;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Abhay
 * Date: 2/23/14
 * Time: 3:24 PM
 */
public abstract class ClassEntity
{
    public boolean[] accessFlags;
    public String name;
    public String descriptor;
    public Map<String, Attribute> attributeNameAttributeMap = new HashMap<String, Attribute>();

    public ConstantPool constantPool;

    public ClassEntity( ConstantPool constantPool )
    {
        this.constantPool = constantPool;
    }

    public void addAttribute( Attribute attribute )
    {
        if( attributeNameAttributeMap.containsKey( attribute.getName()) )
            System.out.println("Attribute already present in attribute map in class entity" + attribute.getName() );
        attributeNameAttributeMap.put( attribute.getName(), attribute );
    }

    public void setParameters( int accessFlags, int nameIndex, int descriptorIndex )
    {
        this.accessFlags = Helper.convertToBooleanArray(accessFlags);
        this.name = constantPool.getUtf8Value( nameIndex );
        this.descriptor = constantPool.getUtf8Value( descriptorIndex );
    }

    public void appendModifiers(StringBuilder fieldStr)
    {
        Map<Integer, String> fieldModifierMap = getModifierMap();

        for( Integer index : fieldModifierMap.keySet() )
        {
            if( accessFlags[ index ] )
                fieldStr.append( fieldModifierMap.get( index ) ).append(" ");
        }
    }

    public String getParsedType( String typeStr )
    {
        return Helper.getParsedType( typeStr );
    }

    public abstract String getPrintableString();
    public abstract Map<Integer, String> getModifierMap();

}
