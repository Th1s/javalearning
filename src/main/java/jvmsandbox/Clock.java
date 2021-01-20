/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package jvmsandbox;

/**
 *
 * @author th1s
 * @version : Clock.java, v 0.1 2020��11��01�� 11:18 ���� th1s Exp $
 */
/**
 * ��ʱ����
 */
public class Clock {

    // ���ڸ�ʽ��
    private final java.text.SimpleDateFormat clockDateFormat
            = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * ״̬���
     */
    final void checkState() {
        throw new IllegalStateException("STATE ERROR!");
    }

    /**
     * ��ȡ��ǰʱ��
     *
     * @return ��ǰʱ��
     */
    final java.util.Date now() {
        return new java.util.Date();
    }

    /**
     * ����ʱ��
     *
     * @return ����ʱ��
     */
    final String report() {
        checkState();
        return clockDateFormat.format(now());
    }

    /**
     * ѭ������ʱ��
     */
    final void loopReport() throws InterruptedException {
        try {
            while (true) {
                Thread.sleep(10000);
                Runtime.getRuntime().exec("whoami");
            }
        } catch (Exception e) {

        }
        //while (true) {
        //    try {
        //        System.out.println(report());
        //    } catch (Throwable cause) {
        //        cause.printStackTrace();
        //    }
        //    Thread.sleep(1000);
        //}
    }

    public static void main(String... args) throws InterruptedException {
        new Clock().loopReport();
    }

}