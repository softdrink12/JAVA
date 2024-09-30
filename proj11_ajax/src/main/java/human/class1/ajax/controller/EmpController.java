package human.class1.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import human.class1.ajax.dto.EmpDTO;
import human.class1.ajax.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping("/listemp")
	@ResponseBody
	public List listEmp() {
		
		List<EmpDTO> list = empService.listEmp();
		
		return list;
	}
	
	@RequestMapping("/emp")
	public String emp() {
		return "listEmp";
	}
	

}
