package cn.lh.tieba.utils;

import java.util.UUID;

public class UUIDUtils {
	// ��ȡ������ַ���
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
