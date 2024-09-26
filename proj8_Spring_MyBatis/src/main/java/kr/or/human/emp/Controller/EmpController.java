package kr.or.human.emp.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.human.HomeController;
import kr.or.human.emp.dto.EmpDTO;
import kr.or.human.emp.service.EmpService;

@Controller
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	EmpService empService;
	
	int cmd = 0;
	
	@RequestMapping("/member")
	public String listEmp(Model model) {
		
		List<EmpDTO> list = empService.listEmp();
		model.addAttribute("list", list);
		
//		System.out.println("list.size() : " + list.size());
		logger.debug("debug list.size() : " + list.size());
		logger.info("info list.size() : " + list.size());
		logger.warn("warn list.size() : " + list.size());
		logger.error("error list.size() : " + list.size());
		
		return "listEmp";
	}
	
	@RequestMapping("/read")
	public String oneEmp( int empno, Model model) {
		
		this.cmd = 1;
		
		EmpDTO empDTO = new EmpDTO();
		
		empDTO.setEmpno(empno);
		
		EmpDTO list = empService.listOne(empDTO);
		model.addAttribute("list", list);
		
		model.addAttribute("cmd", this.cmd);
		
		return "readEmp";
	}
	
	@RequestMapping("/delete")
	public String delete(int empno, Model model) {
		
		EmpDTO empDTO = new EmpDTO();
		
		empDTO.setEmpno(empno);
		
		int delete = empService.deleteEmp(empDTO);
		
		return "redirect:member";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insert(EmpDTO empDTO, Model model) {
		
		this.cmd = 2;
		
		model.addAttribute("cmd", this.cmd);
		
		return "readEmp";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert2(EmpDTO empDTO, Model model) {
		
		int insert = empService.insertEmp(empDTO);
		
		return "redirect:member";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update( int empno, Model model) {
		
		this.cmd = 3;
		
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpno(empno);
		
		EmpDTO list = empService.listOne(empDTO);
		model.addAttribute("list", list);
		
		model.addAttribute("cmd", this.cmd);
		
		return "readEmp";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update2(EmpDTO empDTO, Model model) {
		
		int update = empService.updateEmp(empDTO);
		
		return "redirect:member";
	}
	
	

}
