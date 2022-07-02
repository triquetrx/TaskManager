package com.triquetrx.SpringApplication.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.triquetrx.SpringApplication.Service.TodoService;
import com.triquetrx.SpringApplication.web.model.Todo;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todos;
	
	@RequestMapping(value = { "welcome", "", "/" }, method = RequestMethod.GET)
	public String welcomePageController(ModelMap map) {
		map.put("todoList", todos.retrieveTodos("Zaid"));
		map.addAttribute("name", getLoggedinUserName());
		return "welcome";
	}
	
	private String getLoggedinUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addTodo(ModelMap model) {
		model.put("todo", new Todo());
		return "add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		}
		todos.addTodo("Zaid", todo.getDesc(), todo.getTodoDate().toString(), false);
		return "redirect:welcome";
	}

	@RequestMapping(value = "done", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todos.deleteTodo(id);
		return "redirect:welcome";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editTodos(ModelMap model, int id) {
		model.put("todo", todos.retrieveTodo(id));
		return "edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editedTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		}
		todos.editTodo(todo, todo.getDesc(), todo.getTodoDate());
		return "redirect:welcome";
	}

}
