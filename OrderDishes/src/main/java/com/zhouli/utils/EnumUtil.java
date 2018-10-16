package com.zhouli.utils;

import com.zhouli.enums.CodeEnum;
import com.zhouli.enums.OrderStatusEnum;

public class EnumUtil {
	public static <T extends CodeEnum> T getByCode(Byte enumStatus, Class<T> enumClass) {
		for (T each : enumClass.getEnumConstants()) {
			if (enumStatus.equals(each.getCode())) {
				return each;
			}
		}
		return null;
	}
}
