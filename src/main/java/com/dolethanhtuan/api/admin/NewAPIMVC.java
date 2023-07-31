package com.dolethanhtuan.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dolethanhtuan.dto.NewDTO;
import com.dolethanhtuan.service.INewService;

@RestController()
public class NewAPIMVC {
	@Autowired
	private INewService newService;
	
	
	@PostMapping(value = "/new-api")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newService.save(newDTO);
	}
	@PutMapping(value = "/new-api")
	public NewDTO updateNew(@RequestBody NewDTO newDTO) {
		if(newDTO.getId() == null)
			return null;
		return newService.save(newDTO);
	}
	@DeleteMapping(value = "/new-api")
	public void deleteNew(@RequestBody Long ids[]) {
		newService.delete(ids);;
	}
	@GetMapping(value = "/new-api/{id}")
	public NewDTO getNew(@PathVariable("id") Long id) {
		return newService.findOneById(id);
	}
	@GetMapping(value = "/new-api")
	public NewDTO getNew2(@RequestParam("id") Long id) {
		return newService.findOneById(id);
	}
//	@GetMapping(value = "/new-api/newest")
//	public NewDTO getNewest() {
//		return newService.findOneNewest();
//	}
}
