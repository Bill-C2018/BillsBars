package com.billsbars.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billsbars.app.model.BarTypes;
import com.billsbars.app.model.BaseColor;
import com.billsbars.app.model.BaseScents;
import com.billsbars.app.model.BaseTypes;
import com.billsbars.app.model.ColorRecipe;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.ScentRecipe;
import com.billsbars.app.service.ColorRecipesService;
import com.billsbars.app.service.ScentRecipeService;
import com.billsbars.app.model.MoldStyle;

@RestController
public class BarTypesController {

	Logger logger = LoggerFactory.getLogger(ScentRecipeController.class);
	
	@Autowired
	private ScentRecipeService scentRecipeService;

	@Autowired
	private ColorRecipesService colorRecipesService;
	
	@GetMapping(value = "/bartypes")
	public ResponseEntity<ResponseModel> getBarTypes() {
		
		logger.info("Calling bartypes");
		ResponseModel resp = new ResponseModel();
		ArrayList<BarTypes> t = new ArrayList<BarTypes>();
		for (BarTypes type: BarTypes.values()) {
			t.add(type);
		}
		resp.setBarTypes(t);
		resp.setCode("200");
		resp.setMessage("BarTypes retrieved = " + Integer.toString(t.size()));
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
		resp.setCode("200");
		resp.setMessage("MoldTypes retrieved = " + Integer.toString(t.size()));
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
		resp.setCode("200");
		resp.setMessage("BaseColors retrieved = " + Integer.toString(t.size()));
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
		resp.setMessage("BaseScents retrieved = " + Integer.toString(t.size()));
		resp.setCode("200");
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
	
	@GetMapping(value ="/newsoap")
	public ResponseEntity<ResponseModel> getSoapIngrediants() {
		
		logger.info("Calling get soap ingrediants");
		ResponseModel resp = new ResponseModel();
		ArrayList<MoldStyle> moldStyles = new ArrayList<MoldStyle>();
		ArrayList<BarTypes> barTypes = new ArrayList<BarTypes>();
		ArrayList<BaseTypes> baseTypes = new ArrayList<BaseTypes>();
		List<ColorRecipe> colors = null;
		List<ScentRecipe> scents = null;
		try {
			colors = colorRecipesService.getAllColors();
			scents = scentRecipeService.getAllScents();
			
			for (MoldStyle type: MoldStyle.values()) {
				moldStyles.add(type);
			}
			
			for (BarTypes type: BarTypes.values()) {
				barTypes.add(type);
			}
			
			for (BaseTypes wax: BaseTypes.values()) {
				baseTypes.add(wax);
			}
		} catch (Exception e) {
			resp.setCode("500");
			resp.setMessage("Error fetching data");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
		}
		
		resp.setMoldStyles(moldStyles);
		resp.setBarTypes(barTypes);
		resp.setBaseTypes(baseTypes);
		String[] c = new String[colors.size()+1];
		int count = 0;
		c[count++] = "NONE";
		for (ColorRecipe ac: colors) {
			c[count++] = ac.getFinalColor();
		}
		resp.setColorRecipeNames(c);
		
		String[] s = new String[scents.size() + 1];
		count = 0;
		s[count++] = "NONE";
		for (ScentRecipe sc: scents) {
			s[count++] = sc.getName();
		}
		resp.setScentRecipeNames(s);
		
		resp.setCode("200");
		resp.setMessage("all is good");
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}


	
}
