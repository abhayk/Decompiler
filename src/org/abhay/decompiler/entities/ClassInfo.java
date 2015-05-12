package org.abhay.decompiler.entities;

import org.abhay.decompiler.attributes.Attribute;
import org.abhay.decompiler.attributes.AttributeException;
import org.abhay.decompiler.attributes.Attributes;
import org.abhay.decompiler.main.Constants;
import org.abhay.decompiler.util.Helper;
import org.abhay.decompiler.main.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Abhay
 * Date: 1/25/14
 * Time: 7:22 PM
 */
public class ClassInfo
{
    private int majorVersion;
    private int minorVersion;
    private boolean[] accessFlags;
    private String name;
    private String superClass;

    private ConstantPool constantPool;
    private List<String> interfaces;
    private List<FieldInfo> fields;
    private List<MethodInfo> methods;
    private Map<String, Attribute> attributeNameAttributeMap;

    public ClassInfo()
    {
        fields = new ArrayList<FieldInfo>();
        methods = new ArrayList<MethodInfo>();
        attributeNameAttributeMap = new HashMap<String, Attribute>();
    }

    public String getHeaderString()
    {
        StringBuilder header = new StringBuilder();

        Map<Integer, String> classAccessModifierMap = Constants.getClassModifierMap();

        for( Integer index : classAccessModifierMap.keySet() )
        {
            if( accessFlags[ index ] )
                header.append( classAccessModifierMap.get( index ) ).append(" ");
        }

        if( !isAccessInterface() )
            header.append("class ");

        header.append( getName() ).append(" ");

        if( !superClass.equals("java/lang/Object"))
        {
            header.append("extends ").append( superClass ).append(" ");
        }

        if( interfaces.size() > 0)
        {
            header.append("implements ");

            for(String i : getInterfaces() )
                header.append(i).append(",");

            header.deleteCharAt( header.length() -  1);
        }
        return header.toString();
    }

    public boolean isAccessInterface()
    {
        return accessFlags[ Constants.CLASS_ACC_INTERFACE];
    }

    public void setAccessFlags(int accessFlags)
    {
        this.accessFlags = Helper.convertToBooleanArray(accessFlags);
    }

    public void setName( int index )
    {
        this.name = constantPool.getUtf8StringFromClassInfo( index );
    }

    public void setInterfaces(List<Integer> interfaces)
    {
        this.interfaces = new ArrayList<String>();
        for( Integer i : interfaces )
        {
            this.interfaces.add( constantPool.getUtf8StringFromClassInfo( i ) );
        }
    }

    public void setSuperClass(int index)
    {
        this.superClass = constantPool.getUtf8StringFromClassInfo( index );
    }

    public FieldInfo addField()
    {
        FieldInfo fieldInfo = new FieldInfo( constantPool );
        fields.add( fieldInfo );
        return fieldInfo;
    }

    public MethodInfo addMethod()
    {
        MethodInfo methodInfo = new MethodInfo( constantPool );
        methods.add( methodInfo );
        return methodInfo;
    }

    public void addClassAttribute( Attribute attribute )
    {
        if( attributeNameAttributeMap.containsKey( attribute.getName()) )
            System.out.println("Attribute already present in attribute map in class entity" + attribute.getName() );
        attributeNameAttributeMap.put( attribute.getName(), attribute );
    }

    public Attribute formAttribute( int nameIndex, int length, byte[] info ) throws AttributeException
    {
        return Attributes.formAttribute(constantPool, nameIndex, length, info);
    }

    public String getPrintableString()
    {
        Printer printer = new Printer();

        printer.printLine( getHeaderString() );

        printer.openBrace();

        for( FieldInfo fieldInfo : fields )
            printer.printLine( fieldInfo.getPrintableString() );

        for( MethodInfo methodInfo : methods )
            printer.printLine( methodInfo.getPrintableString() );

        printer.closeBrace();

        return printer.get();
    }

    public List<FieldInfo> getFields()
    {
        return fields;
    }

    public List<MethodInfo> getMethods()
    {
        return methods;
    }

    public void setMajorVersion(int majorVersion)
    {
        this.majorVersion = majorVersion;
    }

    public void setMinorVersion(int minorVersion)
    {
        this.minorVersion = minorVersion;
    }

    public List<String> getInterfaces()
    {
        return interfaces;
    }

    public String getName()
    {
        return name;
    }

    public void setConstantPool(ConstantPool constantPool)
    {
        this.constantPool = constantPool;
    }
}