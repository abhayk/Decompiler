package org.abhay.decompiler.entities;

import org.abhay.decompiler.attributes.CodeAttribute;
import org.abhay.decompiler.attributes.ExceptionAttribute;
import org.abhay.decompiler.attributes.LocalVariableTableAttribute;
import org.abhay.decompiler.main.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Abhay
 * Date: 2/23/14
 * Time: 7:30 PM
 */
public class MethodInfo extends ClassEntity
{
    public MethodInfo(ConstantPool constantPool)
    {
        super(constantPool);
    }

    @Override
    public String getPrintableString()
    {
        StringBuilder methodStr = new StringBuilder();

        appendModifiers(methodStr);

        appendReturnType( methodStr );

        methodStr.append( name );

        appendArguments( methodStr );

        appendExceptionsThrown ( methodStr );

        if( isAbstract() )
            methodStr.append(";");
        else
            methodStr.append("\n").append( getCodeString() );

        return methodStr.toString();
    }

    @Override
    public Map<Integer, String> getModifierMap()
    {
        return Constants.getMethodModifierMap();
    }

    public String getCodeString()
    {
        return getCodeAttributeForMethod().getPrintableString();
    }

    private void appendReturnType( StringBuilder methodStr )
    {
        String typeStr = descriptor.substring( descriptor.lastIndexOf( ")" ) + 1 );
        methodStr.append( getParsedType( typeStr ) ).append(" ");
    }

    private void appendArguments( StringBuilder methodStr )
    {
        methodStr.append("( ");

        List<String> argumentTypes = getArgumentTypes();

        if( isAbstract() )
        {
            int i = 0;
            for( String argumentType : argumentTypes )
            {
                methodStr.append( argumentType ).append(" ").append("p").append( i++ ).append(", ");
            }
        }
        else
        {
            CodeAttribute codeAttribute = getCodeAttributeForMethod();

            LocalVariableTableAttribute localVariableTableAttribute = codeAttribute.getLocalVariableTableAttribute();

            if( localVariableTableAttribute != null )
            {
                LocalVariableInfo[] localVariableInfos = localVariableTableAttribute.getLocalVariableInfos();

                int index = 0;

                if( !isStatic() )
                    index++;

                for( String argumentType : argumentTypes )
                {
                    methodStr.append(argumentType).append(" ").append( getLocalVariableName( localVariableInfos, index ) ).append(", ");
                }
            }
        }

        if( argumentTypes.size() > 0)
            methodStr.deleteCharAt( methodStr.length() - 2 );
        methodStr.append(")");
    }

    private void appendExceptionsThrown( StringBuilder methodStr )
    {
        ExceptionAttribute exceptionAttribute = getExceptionAttributeForMethod();

        if( exceptionAttribute != null )
        {
            methodStr.append(" ").append("throws ").append( exceptionAttribute.getPrintableString() );
        }
    }

    private List<String> getArgumentTypes()
    {
        List<String> argumentTypes = new ArrayList<String>();

        char[] descriptorArr = descriptor.toCharArray();

        int i = 1;
        StringBuilder tmp = new StringBuilder();

        while( descriptorArr[i] != ')' )
        {
            if( descriptorArr[i] == '[' )
                tmp.append( descriptorArr[i++] );
            else if( descriptorArr[i] == 'L')
            {
                String refType = descriptor.substring(i, descriptor.indexOf(";", i));
                tmp.append( refType );
                argumentTypes.add( getParsedType( tmp.toString() ));
                tmp = new StringBuilder();
                i+= refType.length() + 1;
            }
            else
            {
                tmp.append(descriptorArr[i++]);
                argumentTypes.add( getParsedType( tmp.toString() ));
                tmp = new StringBuilder();
            }
        }
        return argumentTypes;
    }

    private CodeAttribute getCodeAttributeForMethod()
    {
        return ( CodeAttribute ) attributeNameAttributeMap.get( Constants.CODE_ATTRIBUTE_NAME );
    }

    private ExceptionAttribute getExceptionAttributeForMethod()
    {
        return ( ExceptionAttribute ) attributeNameAttributeMap.get( Constants.EXCEPTION_ATTRIBUTE_NAME );
    }

    private boolean isStatic()
    {
        return accessFlags[ Constants.METHOD_STATIC ];
    }

    public boolean isAbstract()
    {
        return accessFlags[ Constants.METHOD_ABSTRACT ];
    }

    private String getLocalVariableName( LocalVariableInfo[] localVariableInfos, int index )
    {
        if( ( index + 1 ) > localVariableInfos.length )
            return "p" + index;
        else
            return localVariableInfos[ index ].getName();
    }
}
