package org.abhay.decompiler.attributes;

import org.abhay.decompiler.entities.ConstantPool;
import org.abhay.decompiler.main.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Abhay
 * Date: 2/2/14
 * Time: 6:47 PM
 */
public class Attributes
{
    private static final Map< String, Class> attributeMap;

    static
    {
        attributeMap = new HashMap<String, Class>();

        attributeMap.put( Constants.CONSTANT_VALUES_ATTRIBUTE_NAME, ConstantValueAttribute.class);
        attributeMap.put( Constants.SIGNATURE_ATTRIBUTE_NAME, SignatureAttribute.class);
        attributeMap.put( Constants.SYNTHETIC_ATTRIBUTE_NAME, SyntheticAttribute.class);
        attributeMap.put( Constants.CODE_ATTRIBUTE_NAME, CodeAttribute.class);
        attributeMap.put( Constants.LOCAL_VARIABLE_TABLE_ATTRIBUTE_NAME, LocalVariableTableAttribute.class);
        attributeMap.put( Constants.LINE_NUMBER_TABLE_ATTRIBUTE_NAME, LineNumberTableAttribute.class);
        attributeMap.put( Constants.EXCEPTION_ATTRIBUTE_NAME, ExceptionAttribute.class );
        attributeMap.put( Constants.SOURCE_FILE_ATTRIBUTE_NAME, SourceFileAttribute.class );
        attributeMap.put( Constants.STACK_MAP_TABLE_ATTRIBUTE_NAME, StackMapTableAttribute.class );
        attributeMap.put( Constants.LOCAL_VARIABLE_TYPE_TABLE_ATTRIBUTE_NAME, LocalVariableTypeTableAttribute.class);
        attributeMap.put( Constants.ENCLOSING_METHOD_ATTRIBUTE_NAME, EnclosingMethodAttribute.class );
        attributeMap.put( Constants.INNER_CLASSES_ATTRIBUTE_NAME, InnerClassesAttribute.class );
    }

    public static Attribute formAttribute(ConstantPool constantPool, int nameIndex, int length, byte[] info) throws AttributeException
    {
        String name = constantPool.getUtf8Value( nameIndex );

        Attribute attribute = getNewInstance( name );

        attribute.setParameters( constantPool, name, length, info );

        return attribute;
    }

    private static Attribute getNewInstance( String name ) throws AttributeException
    {
        Class attributeClass = attributeMap.get( name );
        if( attributeClass == null )
            throw new AttributeException( "Specified attribute not defined", name );

        Attribute attribute;
        try
        {
            attribute = ( Attribute ) attributeClass.newInstance();
        }
        catch (InstantiationException e)
        {
            throw new AttributeException("Error instantiating attribute", name, e);
        }
        catch (IllegalAccessException e)
        {
            throw new AttributeException("Error instantiating attribute", name, e);
        }
        return attribute;
    }

}
