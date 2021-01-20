/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author th1s
 * @version : FileToHex.java, v 0.1 2020��09��27�� 8:44 ���� th1s Exp $
 */
public class FileToHex {
    @Test
    public void print() {
        classToHex();
    }

    public void classToHex(){
        try {
            StringBuffer sb = new StringBuffer();
            FileInputStream fis = new FileInputStream("/Users/th1s/programming/java/javalearning/target/classes/SkywalkingTest2.class");
            java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int read = 1024;
            int readSize = 1024;
            while (read == readSize) {
                read = fis.read(buffer, 0, readSize);
                bos.write(buffer, 0, read);
            }
            // �õ�ͼƬ���ֽ�����
            //System.out.println(bos.toString());

            byte[] result = bos.toByteArray();
            // �ֽ�����ת��ʮ������
            String str = byte2HexStr(result);
            /*
             * ��ʮ�����ƴ����浽txt�ļ���
             */
            System.out.println(str);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /*
     * ʵ���ֽ�������ʮ�����Ƶ�ת������һ
     */
    public static String byte2HexStr(byte[] b)
    {
        String hs = "";
        String stmp = "";

        for (int n = 0; n < b.length; n++)
        {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }
}