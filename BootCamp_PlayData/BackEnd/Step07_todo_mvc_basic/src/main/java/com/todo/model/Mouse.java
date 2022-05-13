package com.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter // 세터
@Getter // 게터
@ToString // 투 스트링
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@Builder // 빌더!
public class Mouse {
	private String name;
}
