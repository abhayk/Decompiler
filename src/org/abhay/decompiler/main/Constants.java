package org.abhay.decompiler.main;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Abhay
 * Date: 1/26/14
 * Time: 5:46 PM
 */
public class Constants
{
    private Constants()
    {
    }

    public static final int VARIABLE_BYTES = -1;

    public static final int CLASS_ACC_PUBLIC = 0;
    public static final int CLASS_ACC_FINAL = 4;
    public static final int CLASS_ACC_SUPER = 5;
    public static final int CLASS_ACC_INTERFACE = 9;
    public static final int CLASS_ACC_ABSTRACT = 10;
    public static final int CLASS_ACC_SYNTHETIC = 12;
    public static final int CLASS_ACC_ANNOTATION = 13;
    public static final int CLASS_ACC_ENUM = 14;

    public static final int FIELD_PUBLIC = 0;
    public static final int FIELD_PRIVATE = 1;
    public static final int FIELD_PROTECTED = 2;
    public static final int FIELD_STATIC = 3;
    public static final int FIELD_FINAL = 4;
    public static final int FIELD_VOLATILE = 6;
    public static final int FIELD_TRANSIENT = 7;

    public static final int METHOD_PUBLIC = 0;
    public static final int METHOD_PRIVATE = 1;
    public static final int METHOD_PROTECTED = 2;
    public static final int METHOD_STATIC = 3;
    public static final int METHOD_FINAL = 4;
    public static final int METHOD_SYNCHRONIZED = 5;
    public static final int METHOD_BRIDGE = 6;
    public static final int METHOD_VARARGS = 7;
    public static final int METHOD_NATIVE = 8;
    public static final int METHOD_ABSTRACT = 10;
    public static final int METHOD_STRICT = 11;
    public static final int METHOD_SYNTHETIC = 12;

    public static final String BYTE_STR = "byte";
    public static final String CHAR_STR = "char";
    public static final String DOUBLE_STR = "double";
    public static final String FLOAT_STR = "float";
    public static final String INT_STR = "int";
    public static final String LONG_STR = "long";
    public static final String SHORT_STR = "short";
    public static final String BOOLEAN_STR = "boolean";
    public static final String VOID_STR = "void";

    private static Map<String, String> baseTypeMap = null;
    private static Map<Integer, String> classModifierMap = null;
    private static Map<Integer, String> fieldModifierMap = null;
    private static Map<Integer, String> methodModifierMap = null;

    public static Map<Integer, String> getClassModifierMap()
    {
        if( classModifierMap == null )
        {
            classModifierMap = new HashMap<Integer, String>();
            classModifierMap.put(CLASS_ACC_PUBLIC, "public");
            classModifierMap.put(CLASS_ACC_FINAL, "final");
            classModifierMap.put(CLASS_ACC_INTERFACE, "interface");
            classModifierMap.put(CLASS_ACC_ABSTRACT, "abstract");
            classModifierMap.put(CLASS_ACC_ABSTRACT, "enum");
        }
        return classModifierMap;
    }

    public static Map<Integer, String> getFieldModifierMap()
    {
        if( fieldModifierMap == null )
        {
            fieldModifierMap = new HashMap<Integer, String>();
            fieldModifierMap.put(FIELD_PUBLIC, "public");
            fieldModifierMap.put(FIELD_PRIVATE, "private");
            fieldModifierMap.put(FIELD_PROTECTED, "protected");
            fieldModifierMap.put(FIELD_STATIC, "static");
            fieldModifierMap.put(FIELD_FINAL, "final");
            fieldModifierMap.put(FIELD_VOLATILE, "volatile");
            fieldModifierMap.put(FIELD_TRANSIENT, "transient");
        }
        return fieldModifierMap;
    }

    public static Map<Integer, String> getMethodModifierMap()
    {
        if( methodModifierMap == null )
        {
            methodModifierMap = new HashMap<Integer, String>();
            methodModifierMap.put(METHOD_PUBLIC, "public");
            methodModifierMap.put(METHOD_PRIVATE, "private");
            methodModifierMap.put(METHOD_PROTECTED, "protected");
            methodModifierMap.put(METHOD_STATIC, "static");
            methodModifierMap.put(METHOD_FINAL, "final");
            methodModifierMap.put(METHOD_SYNCHRONIZED, "synchronized");
            methodModifierMap.put(METHOD_BRIDGE, "--bridge--");
            methodModifierMap.put(METHOD_VARARGS, "--varargs--");
            methodModifierMap.put(METHOD_NATIVE, "native");
            methodModifierMap.put(METHOD_ABSTRACT, "abstract");
            methodModifierMap.put(METHOD_STRICT, "--strict--");
            methodModifierMap.put(METHOD_SYNTHETIC, "--synthetic--");
        }
        return methodModifierMap;
    }

    public static Map<String, String> getBaseTypeMap()
    {
        if( baseTypeMap == null )
        {
            baseTypeMap = new HashMap<String, String>();
            baseTypeMap.put("B", BYTE_STR);
            baseTypeMap.put("C", CHAR_STR);
            baseTypeMap.put("D", DOUBLE_STR);
            baseTypeMap.put("F", FLOAT_STR);
            baseTypeMap.put("I", INT_STR);
            baseTypeMap.put("J", LONG_STR);
            baseTypeMap.put("S", SHORT_STR);
            baseTypeMap.put("Z", BOOLEAN_STR);
            baseTypeMap.put("V", VOID_STR);
        }
        return baseTypeMap;
    }

    public static final String CODE_ATTRIBUTE_NAME = "Code";
    public static final String CONSTANT_VALUES_ATTRIBUTE_NAME = "ConstantValue";
    public static final String EXCEPTION_ATTRIBUTE_NAME = "Exceptions";
    public static final String INNER_CLASSES_ATTRIBUTE_NAME = "InnerClasses";
    public static final String LINE_NUMBER_TABLE_ATTRIBUTE_NAME = "LineNumberTable";
    public static final String LOCAL_VARIABLE_TABLE_ATTRIBUTE_NAME = "LocalVariableTable";
    public static final String SOURCE_FILE_ATTRIBUTE_NAME = "SourceFile";
    public static final String SYNTHETIC_ATTRIBUTE_NAME = "Synthetic";
    public static final String SIGNATURE_ATTRIBUTE_NAME = "Signature";
    public static final String STACK_MAP_TABLE_ATTRIBUTE_NAME = "StackMapTable";
    public static final String LOCAL_VARIABLE_TYPE_TABLE_ATTRIBUTE_NAME = "LocalVariableTypeTable";
    public static final String ENCLOSING_METHOD_ATTRIBUTE_NAME = "EnclosingMethod";

    public static final int UTF8_TAG = 1;
    public static final int INTEGER_TAG = 3;
    public static final int FLOAT_TAG = 4;
    public static final int LONG_TAG = 5;
    public static final int DOUBLE_TAG = 6;
    public static final int CLASS_TAG = 7;
    public static final int STRING_TAG = 8;
    public static final int FIELD_REF_TAG = 9;
    public static final int METHOD_REF_TAG = 10;
    public static final int INTERFACE_METHOD_REF_TAG = 11;
    public static final int NAME_AND_TYPE_TAG = 12;

}
