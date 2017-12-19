package cn.lh.tieba.utils;

import java.util.UUID;

public class UUIDUtils {
	// 获取随机的字符串
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
