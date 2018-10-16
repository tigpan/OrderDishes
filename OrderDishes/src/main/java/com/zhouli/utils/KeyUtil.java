package com.zhouli.utils;

import java.util.Random;

/*产生随机数 产生独一无二的随机数 使用synchronized表示线程同步
 * 这是一个知识点需要学习
 * 产生唯一的主键：当前的毫秒数+随机数，随机数位数相同 synchronized可防止多线程并发时重复
 * */
public class KeyUtil {
	public static synchronized String genUniqueKey() {
		Integer number = new Random().nextInt(900000) + 100000;
		return System.currentTimeMillis() + String.valueOf(number);
	}
}
