package gugu.service;

import java.util.ArrayList;
import java.util.List;

import gugu.dto.GuguDTO;

public class GuguService {

	
	
		public List<GuguDTO> gugudan(int text) {
			
			List<GuguDTO> gugu = new ArrayList<GuguDTO>();
			
			for(int i = 1; i < 10; i++) {
				GuguDTO dto = new GuguDTO();
				dto.setNum1(i);
				dto.setNum2(text);
				dto.setResult(i * text);
				
				gugu.add(dto);
			}
			return gugu;
		}
	
	
}
