package com.billsbars.app.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billsbars.app.model.BarTypes;
import com.billsbars.app.model.BaseColor;
import com.billsbars.app.model.BaseScents;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.MoldStyle;

@RestController
public class BarTypesController {

	Logger logger = LoggerFactory.getLogger(ScentRecipeController.class);
	
	
	@GetMapping(value = "/bartypes")
	public ResponseEntity<ResponseModel> getBarTypes() {
		
		ResponseModel resp = new ResponseModel();
		ArrayList<BarTypes> t = new ArrayList<BarTypes>();
		for (BarTypes type: BarTypes.values()) {
			t.add(type);
		}
		resp.setBarTypes(t);
		resp.setCode(200);
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
		
	@GetMapping(value = "/moldtypes")
	public ResponseEntity<ResponseModel> getMoldTypes() {
		
		ResponseModel resp = new ResponseModel();
		ArrayList<MoldStyle> t = new ArrayList<MoldStyle>();
		for (MoldStyle type: MoldStyle.values()) {
			t.add(type);
		}
		resp.setMoldStyles(t);
		resp.setCode(200);
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
	
	@GetMapping(value = "/basecolors")
	public ResponseEntity<ResponseModel> getBaseColors() {
		
		logger.info("calling get base colors");
		ResponseModel resp = new ResponseModel();
		ArrayList<BaseColor> t = new ArrayList<BaseColor>();
		for (BaseColor type: BaseColor.values()) {
			t.add(type);
		}
		resp.setBaseColors(t);
		resp.setCode(200);
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
	
	@GetMapping(value = "/basescents")
	public ResponseEntity<ResponseModel> getBaseScents() {
		
		logger.info("Calling getBaseScents");
		ResponseModel resp = new ResponseModel();
		ArrayList<BaseScents> t = new ArrayList<BaseScents>();
		for (BaseScents type: BaseScents.values()) {
			t.add(type);
		}
		resp.setBaseScents(t);
		resp.setCode(200);
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}


	
}
