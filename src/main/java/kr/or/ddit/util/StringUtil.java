package kr.or.ddit.util;

import java.io.File;

public class StringUtil {
	public static String getFileNameFrimHeader(String ContentDisposition){

		int StringStart = ContentDisposition.indexOf("filename=");
		int StringEnd = ContentDisposition.lastIndexOf("\"");
		String fileName = ContentDisposition.substring(StringStart+10, StringEnd);
		// 파일쓰기
		// url 정보를 실제 파일경로로 변경
		
		return fileName;
		
	}
}
