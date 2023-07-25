package com.multi.mongoDB13;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemoController {

	@Autowired
	MemoService service;//300, di
	
	@RequestMapping("delete.memo")
	public String delete(String _id) {
		service.delete(_id);
		return "redirect:mongo_memo.jsp";
	}
	@RequestMapping("update.memo")
	public String update(String _id, String content) {
		MemoDTO dto = new MemoDTO();
		dto.set_id(_id);
		dto.setContent(content);
		service.update(dto);
		System.out.println("controller>> " + dto);
		return "redirect:mongo_memo.jsp";
	}
	
	@RequestMapping("one.memo") //one.memo?_id=100
	public void one(String _id, Model model) {
		MemoDTO dto = service.one(_id);
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping("insert.memo")
	public void insert(MemoDTO memoDTO) {
		System.out.println(memoDTO);
		service.insert(memoDTO);
	}
	
	//요청하나당 함수 하나.!!
	@RequestMapping("list.memo")
	public void list(Model model) {
		List<MemoDTO> list = service.list();
		model.addAttribute("list", list);
	}
}
