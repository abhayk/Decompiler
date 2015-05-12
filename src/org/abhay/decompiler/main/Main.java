package org.abhay.decompiler.main;

import org.abhay.decompiler.attributes.Attribute;
import org.abhay.decompiler.attributes.AttributeException;
import org.abhay.decompiler.entities.*;
import org.abhay.decompiler.util.Helper;
import org.abhay.decompiler.util.Timer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public void process( String[] args ) throws IOException, AttributeException
    {
        Settings.initializeSettings( args );

        List<String> files = Settings.getPaths();

        for( String file : files )
        {
            process( file );
        }
    }

    private void process( String file ) throws IOException, AttributeException
    {
        System.out.println("Processing file - " + file + "\n" );

        DataInputStream dis = new DataInputStream( new FileInputStream( file ) );

        ClassInfo classInfo = new ClassInfo();

        byte[] magic = new byte[4];
        dis.read( magic );

        if(!checkMagic( magic ))
            return;

        classInfo.setMinorVersion( dis.readUnsignedShort() );

        classInfo.setMajorVersion( dis.readUnsignedShort() );

        classInfo.setConstantPool( readConstantPool( dis ) );

        classInfo.setAccessFlags( dis.readUnsignedShort() );

        classInfo.setName( dis.readUnsignedShort() );

        classInfo.setSuperClass( dis.readUnsignedShort() );

        classInfo.setInterfaces( readInterfaces(dis) );

        readFields( dis, classInfo );

        readMethods( dis, classInfo );

        readClassAttributes( dis, classInfo );

        dis.close();

        System.out.println( classInfo.getPrintableString() );
    }

    private ConstantPool readConstantPool(DataInputStream dis) throws IOException
    {
        ConstantPool constantPool = new ConstantPool();

        int constantCount = dis.readUnsignedShort();

        while(constantPool.getConstantsRead() < constantCount - 1)
        {
            int entryType = Helper.getInt(dis.readByte());
            switch (entryType)
            {
                case Constants.UTF8_TAG:
                {
                    int length = dis.readUnsignedShort();
                    byte[] s = new byte[ length ];
                    dis.read(s);
                    constantPool.add( entryType, null, null, new String( s ) );
                    break;
                }
                case Constants.INTEGER_TAG:
                {
                    constantPool.add( entryType, null, null, dis.readInt() );
                    break;
                }
                case Constants.FLOAT_TAG:
                {
                    constantPool.add( entryType, null, null, dis.readFloat() );
                    break;
                }
                case Constants.LONG_TAG:
                {
                    constantPool.add( entryType, null, null, dis.readLong() );
                    break;
                }
                case Constants.DOUBLE_TAG:
                {
                    constantPool.add( entryType, null, null, dis.readDouble() );
                    break;
                }
                case Constants.CLASS_TAG:
                {
                    constantPool.add( entryType, dis.readUnsignedShort(), null, null );
                    break;
                }
                case Constants.STRING_TAG:
                {
                    constantPool.add( entryType, dis.readUnsignedShort(), null, null );
                    break;
                }
                case Constants.FIELD_REF_TAG:
                {
                    constantPool.add( entryType, dis.readUnsignedShort(), dis.readUnsignedShort(), null );
                    break;
                }
                case Constants.METHOD_REF_TAG:
                {
                    constantPool.add( entryType, dis.readUnsignedShort(), dis.readUnsignedShort(), null );
                    break;
                }
                case Constants.INTERFACE_METHOD_REF_TAG:
                {
                    constantPool.add( entryType, dis.readUnsignedShort(), dis.readUnsignedShort(), null );
                    break;
                }
                case Constants.NAME_AND_TYPE_TAG:
                {
                    constantPool.add( entryType, dis.readUnsignedShort(), dis.readUnsignedShort(), null );
                    break;
                }
            }
        }
//        constantPool.print();
        return constantPool;
    }

    private List<Integer> readInterfaces(DataInputStream dis) throws IOException
    {
        List<Integer> interfaces = new ArrayList<Integer>();
        int interfaceCount = dis.readUnsignedShort();

        for(int i=0; i<interfaceCount; i++)
        {
            interfaces.add(dis.readUnsignedShort());
        }
        return interfaces;
    }

    private void readFields( DataInputStream dis, ClassInfo classInfo ) throws IOException, AttributeException
    {
        int fieldsCount = dis.readUnsignedShort();
        for( int i=0; i< fieldsCount; i++ )
        {
            FieldInfo field = classInfo.addField();
            readEntity( dis, field, classInfo );
        }
    }

    private void readMethods( DataInputStream dis, ClassInfo classInfo ) throws IOException, AttributeException
    {
        int methodsCount = dis.readUnsignedShort();
        for( int i = 0; i<methodsCount; i++ )
        {
            MethodInfo method = classInfo.addMethod();
            readEntity( dis, method, classInfo );
        }
    }

    private void readClassAttributes( DataInputStream dis, ClassInfo classInfo ) throws IOException, AttributeException
    {
        int attributesCount = dis.readUnsignedShort();

        for( int i=0; i<attributesCount; i++ )
        {
            classInfo.addClassAttribute( formAttribute( dis, classInfo ) );
        }
    }

    private void readEntity( DataInputStream dis, ClassEntity classEntity, ClassInfo classInfo ) throws IOException, AttributeException
    {
        int accessFlags = dis.readUnsignedShort();
        int nameIndex = dis.readUnsignedShort();
        int descriptorIndex = dis.readUnsignedShort();
        int attributesCount = dis.readUnsignedShort();

        classEntity.setParameters( accessFlags, nameIndex, descriptorIndex );

        for( int i=0; i<attributesCount; i++)
        {
            classEntity.addAttribute( formAttribute( dis, classInfo ) );
        }
    }

    private Attribute formAttribute( DataInputStream dis, ClassInfo classInfo ) throws IOException, AttributeException
    {
        int attributeNameIndex = dis.readUnsignedShort();
        int length = dis.readInt();
        byte[] info = new byte[ length ];
        dis.read(info);

        return classInfo.formAttribute( attributeNameIndex, length, info );
    }

    private boolean checkMagic(byte[] data)
    {
        return true; //TODO: Implement check
    }

    private char getChar( byte b )
    {
        return (char)(b & 0xff);
    }

    private void printCharValue( String s )
    {
        for(String s1 : s.split(" "))
            System.out.print((char) Integer.parseInt(s1));

    }

    private void getAllFilesInDirectory( File file, List<String> files )
    {
        for( File subFile : file.listFiles() )
        {
            if( subFile.isDirectory() )
                getAllFilesInDirectory( subFile, files);
            else
                files.add(subFile.getAbsolutePath());
        }
    }

    public static void main(String[] args) throws IOException, AttributeException
    {
        //TODO: Deal with 123 in bytecode
        Timer.start();
        Main main = new Main();
        main.process( args );
//        d.read("D:\\Dropbox\\My Dropbox\\projects\\Decompiler\\out\\production\\Decompiler\\TestFile.class");

//        List<String> files = new ArrayList<String>();
//        File file = new File("G:\\Dropbox\\projects\\Decompiler\\out\\production\\Decompiler");
//        d.getAllFilesInDirectory( file, files );
//
//        for( String file2 : files )
//            d.read( file2 );

        Timer.stopAndPrintInMilli();
    }

}
