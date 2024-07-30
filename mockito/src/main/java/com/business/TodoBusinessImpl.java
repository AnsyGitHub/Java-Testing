package com.business;

import com.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;


//System Under Test (SUT)
public class TodoBusinessImpl {
    private final TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user){
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo:todos){
            if(todo.contains("Spring")){
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user){
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo:todos) {
            if(!todo.contains("Spring")) {
                todoService.deleteTodos(todo);
            }
        }
    }
}
