package com.spb.web.utils;

import com.spb.web.dto.ResultDto;

public class ResultUtil{
	
	public static ResultDto returnSuccess() {
		return new ResultDto("0000");
	}
	
	public static ResultDto returnSuccess(Object data) {
		return new ResultDto("0000", data);
	}
	
}