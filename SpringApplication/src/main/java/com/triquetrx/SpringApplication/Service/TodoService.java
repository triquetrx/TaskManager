package com.triquetrx.SpringApplication.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.triquetrx.SpringApplication.web.model.Todo;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 1;
	
	static {
		todos.add(new Todo(1, "Zaid", "Complete the learning", LocalDate.now().toString(), false));
	}
	
	public List<Todo> retrieveTodos(String user){
		for(Todo dummy:todos) {
			if(dummy.getUser().equalsIgnoreCase(user)) {
				return todos;
			}
		}
		return null;
	}
	
	public void addTodo(String user, String desc, String date,boolean isDone) {
		todoCount++;
		todos.add(new Todo(todoCount,user,desc,date,isDone));
	}
	
	public void editTodo(Todo todo,String desc,String date) {
		for(Todo dummy:todos) {
			if(dummy.getId()==todo.getId()) {
				dummy.setDesc(desc);
				dummy.setTodoDate(date);
				return;
			}
		}
	}
	
	public Todo retrieveTodo(int id) {
		for(Todo dummy:todos) {
			if(dummy.getId()==id) {
				return dummy;
			}
		}
		return null;
	}
	
	public void deleteTodo(int id) {
		Iterator<Todo> itr = todos.iterator();
		while(itr.hasNext()) {
			if(itr.next().getId()==id) {
				itr.remove();
			}
		}
	}

	
}
