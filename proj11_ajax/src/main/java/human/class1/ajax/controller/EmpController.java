package human.class1.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import human.class1.ajax.dto.EmpDTO;
import human.class1.ajax.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	int cmd = 0;
	
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
	
	@DeleteMapping("/delete")
	public String empDTO(@RequestBody EmpDTO empDTO) {
		
		int result = empService.deleteEmp(empDTO);

		System.out.println("삭제 : " + result);
		
		return "redirect:listemp";
	}
	
	@RequestMapping("/read")
	public String read(Model model, int empno) {
		System.out.println("empno : " + empno);
		
		EmpDTO empDTO = new EmpDTO();
		
		empDTO.setEmpno(empno);
		
		EmpDTO list = empService.selectOne(empDTO);
		
		model.addAttribute("list", list);
		model.addAttribute("cmd", 1);
		
		return "readEmp";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		
		model.addAttribute("cmd", 2);
		
		return "readEmp";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	public int insertEmp(@RequestBody EmpDTO empDTO) {
		
		int result = empService.insert(empDTO);
		
		return result;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Model model, int empno) {
		
		System.out.println("empno : " + empno);
		
		EmpDTO empDTO = new EmpDTO();
		
		empDTO.setEmpno(empno);
		
		EmpDTO list = empService.selectOne(empDTO);
		model.addAttribute("list", list);
		
		model.addAttribute("cmd", 3);
		
		return "readEmp";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseBody
	public int updateEmp(@RequestBody EmpDTO empDTO) {
		
		int result = empService.updateEmp(empDTO);
		
		return result;
	}
	

}
