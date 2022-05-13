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
	
	// 새로운 Todo를 등록
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		boolean result = false;
		
		try {
			// 데이터를 파일에 쓰기 위한 준비
			fileOutputStream = new FileOutputStream(RESOURCES + "todo-data-simple.txt", true);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			bufferedWriter = new BufferedWriter(outputStreamWriter);
	        
	        numberOfRows = Files.lines(filePath).count(); // 현재 데이터의 행 수
	        int numberOfTodos = numberOfRows.intValue();
	        
	        numberOfTodos++; // 할 일 순서 번호 1 증가
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
