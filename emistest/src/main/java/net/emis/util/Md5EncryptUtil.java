package net.emis.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.log4j.Logger;

/**
 * md5加密相关方法
 * 
 * @author zousong
 *
 */
public class Md5EncryptUtil {
	
	private static Logger log = Logger.getLogger(Md5EncryptUtil.class);
	//默认加密次数
	private static final int DEFAULT_ENCRYPT_NUM = 1;
	//默认salt
	private static final String DEFAULT_SALT = "EMIS";
	//md5混淆后的salt
	private static final String DEFAULT_SECRET_SALT = getMD5Str(DEFAULT_SALT);
	
	public static void main(String[] args) {
		String p = "HELLO WORLD!";
		String md5 = getMD5Encrypt(p);
		System.out.println(md5);
		/**
		 *  66d095cb99a345e508268c3cf8a4873c
		 */
	}
	
	/**
	 * 获取salt (使用默认的key,properties文件名)
	 * @return salt
	 */
	private static String getMd5Salt(){
		String salt = null;
		String key = "userPsdSalt";
		String file = ClassLoader.getSystemResource("") + "common.properties";
		file = file.replaceFirst("file:/", "");
		salt = getMd5Salt(key, file);
		return salt;
	}
	
	/**
	 * 获取salt
	 * @param key
	 * @param file 配置文件
	 * @return salt
	 */
	private static String getMd5Salt(String key, String file){
		String salt = null;
		salt = PropertiesUtil.getPropertiesValue(key, file);
		return salt;
	}
	
	/**
	 * 获取加密次数（使用默认配置文件及属性）
	 * @return 加密次数
	 */
	private static Integer getEncryptNum(){
		Integer encryptNum = null;
		String key = "encrypt_num";
		String file = ClassLoader.getSystemResource("") + "common.properties";
		file = file.replaceFirst("file:/", "");
		encryptNum = getEncryptNum(key, file);
		return encryptNum;
	}
	
	/**
	 * 获取加密次数
	 * @param key 属性名
	 * @param file 配置文件
	 * @return 加密次数
	 */
	private static Integer getEncryptNum(String key, String file){
		Integer encryptNum = null;
		encryptNum = Integer.valueOf(PropertiesUtil.getPropertiesValue(key, file));
		return encryptNum;
	}
	
	/**
	 * 加上salt进行进一步的加密
	 * @param MD5   待加密串
	 * @param salt 盐值
	 * @param encrypt_num 加密次数 
	 * @return md5(str + salt)^n
	 */
	public static String md5SaltEncrypt(String MD5, String salt, int encrypt_num){
		
		for(int num = 0; num < encrypt_num; num++){
			MD5 += salt;
			MD5 = getMD5Str(MD5);
		}
		
		return MD5;
	}
	
	/**
	 * 获取md5加密串（标准32位小写）</p>result = md5(str + salt)^n
	 * @param str 待加密字串
	 * @return 加密后的字串
	 */
	public static String getMD5Encrypt(String str){
		String salt = getMd5Salt();
		int encrypt_num = getEncryptNum() == null ? 0 : getEncryptNum();
		
		if(salt == null || "".equals(salt) || encrypt_num <= 0){
			str = md5SaltEncrypt(str, DEFAULT_SECRET_SALT, DEFAULT_ENCRYPT_NUM);
		} else {
			String secret_salt = getMD5Str(salt);
			str = md5SaltEncrypt(str, secret_salt, encrypt_num);
		}
		
		return str;
	}
	
	/**
	 * MD5 混淆
	 */
	private static String getMD5Str(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			log.error("加密异常：NoSuchAlgorithmException");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			log.error("编码异常：UnsupportedEncodingException");
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		//将加密后的byte数组转换为十六进制的字符串,否则的话生成的字符串会乱码
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1){
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			}else{
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		}

		return md5StrBuff.toString();
	}
}