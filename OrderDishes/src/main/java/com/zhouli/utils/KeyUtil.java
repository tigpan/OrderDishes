package com.zhouli.utils;

import java.util.Random;

/*��������� ������һ�޶�������� ʹ��synchronized��ʾ�߳�ͬ��
 * ����һ��֪ʶ����Ҫѧϰ
 * ����Ψһ����������ǰ�ĺ�����+������������λ����ͬ synchronized�ɷ�ֹ���̲߳���ʱ�ظ�
 * */
public class KeyUtil {
	public static synchronized String genUniqueKey() {
		Integer number = new Random().nextInt(900000) + 100000;
		return System.currentTimeMillis() + String.valueOf(number);
	}
}
