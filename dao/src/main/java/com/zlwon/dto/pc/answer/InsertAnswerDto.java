package com.zlwon.dto.pc.answer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * pc端新增提问回答入参
 * @author yangy
 *
 */

@Setter
@Getter
@NoArgsConstructor
public class InsertAnswerDto {

	private Integer questionId;  //问题ID
	
	private String content;  //回答内容
}
