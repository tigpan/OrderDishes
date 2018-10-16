package com.zhouli.utils;

import com.zhouli.VO.ResultVO;

public class ResultVOUtil {
	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		System.out.println(object);
		resultVO.setData(object);
		resultVO.setMsg("�ɹ�");
		return resultVO;
	}
	public static ResultVO error(Integer code,String message) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(code);
		resultVO.setMsg(message);
		
		return resultVO;
	}
}
