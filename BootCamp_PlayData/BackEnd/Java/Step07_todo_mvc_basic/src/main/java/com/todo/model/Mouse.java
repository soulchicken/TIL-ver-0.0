package com.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter // ����
@Getter // ����
@ToString // �� ��Ʈ��
@NoArgsConstructor // �⺻ ������
@AllArgsConstructor // ��� �ʵ带 �Ű������� �޴� ������
@Builder // ����!
public class Mouse {
	private String name;
}
