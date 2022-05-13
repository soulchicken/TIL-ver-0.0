package com.todo.data;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import com.todo.model.Todo;

public class TodoTSVWriter {
	// ���ο� todo ���
	FileOutputStream fileOutputStream;
	OutputStreamWriter outputStreamWriter;
	BufferedWriter bufferedWriter;
	
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		boolean result = false;
	
		try {
			// ������ ���Ͽ� ���� ���� �غ�
			fileOutputStream = new FileOutputStream(RESOURCES + "todo-data-simple.txt", true);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			bufferedWriter = new BufferedWriter(outputStreamWriter);			

			Long numberOfRows = Files.lines(filePath).count();
			int numberOfTodos = numberOfRows.intValue();
			
			numberOfTodos++; // �� �� ���� ��ȣ 1 ����
			
			bufferedWriter.newLine();
			bufferedWriter.write(numberOfTodos + "\t");
			bufferedWriter.write("��Ա�" + "\t");
			bufferedWriter.write("2022-03-08" + "\t");
			bufferedWriter.write("���� ���ְ� �Դ´�" + "\t");
			
			if(numberOfRows < Files.lines(filePath).count()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ڿ� ����
			try {
				bufferedWriter.close();
				outputStreamWriter.close();
				fileOutputStream.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
        return result;
	}
	
}
