package com.project2.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project2.model.Todo;

@Service
public class TodoService {
private static List<Todo> todos=new ArrayList<Todo>();
private static int todoCount=3;
static {
	todos.add(new Todo(1,"badri","nath", new Date(),false));
	todos.add(new Todo(2,"badri","kar", new Date(),false));
	todos.add(new Todo(3,"badri","ham", new Date(),false));
}
public List<Todo> retrieveTodos(String user){
	List<Todo> filteredTodos = new ArrayList<Todo>();
	for(Todo todo : todos) {
		if(todo.getUser().equals(user)) {
			filteredTodos.add(todo);
		}
	}
	return filteredTodos;
}
}
