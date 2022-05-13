package com.todo.data;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import com.todo.model.Todo;

public class TodoTSVWriter {
	
	FileOutputStream fileOutputStream;
	OutputStreamWriter outputStreamWriter;
	BufferedWriter bufferedWriter;
	Long numberOfRows;
	
	// ���ο� Todo�� ���
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		boolean result = false;
		
		try {
			// �����͸� ���Ͽ� ���� ���� �غ�
			fileOutputStream = new FileOutputStream(RESOURCES + "todo-data-simple.txt", true);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			bufferedWriter = new BufferedWriter(outputStreamWriter);
	        
	        numberOfRows = Files.lines(filePath).count(); // ���� �������� �� ��
	        int numberOfTodos = numberOfRows.intValue();
	        
	        numberOfTodos++; // �� �� ���� ��ȣ 1 ����
	        bufferedWriter.newLine();
	        bufferedWriter.write(numberOfTodos + "\t");
	        bufferedWriter.write(newTodo.getTitle() + "\t");
	        bufferedWriter.write(newTodo.getDueDate().toString() + "\t");
	        bufferedWriter.write(newTodo.getDescription() + "\t");
	        
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				outputStreamWriter.close();
				fileOutputStream.close();		
				
		        if(numberOfRows < Files.lines(filePath).count()) {
		        	return true;
		        } else {
		        	return false;
		        }
			} catch (Exception e2) {
			}
		}
		
		return result;
	}

}
