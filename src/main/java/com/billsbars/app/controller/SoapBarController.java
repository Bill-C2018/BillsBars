package com.billsbars.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billsbars.app.AccessDeniedException;
import com.billsbars.app.model.BarOfSoap;
import com.billsbars.app.model.BarTypes;
import com.billsbars.app.model.BaseTypes;
import com.billsbars.app.model.MoldStyle;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.UpdateSoapBars;
import com.billsbars.app.service.BarOfSoapService;
import com.billsbars.app.service.UserAuthenticationService;


@RestController
public class SoapBarController {
	
	Logger logger = LoggerFactory.getLogger(SoapBarController.class);
	
	@Autowired
	private BarOfSoapService barOfSoapService;
	
	@Autowired
	private UserAuthenticationService userAuthenticationService;
	
	@PostMapping(value = "/soaps")
	ResponseEntity<ResponseModel> createASoap (
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody BarOfSoap soap) {
		
		logger.info("Calling create soap");

		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}
		
		
		String type = soap.getBarType().toString();
		String butter = soap.getBaseType().toString();
		String mold = soap.getMoldStyle().toString();
		
		if ((type == null || type.trim().isEmpty()) ||
			(butter == null || butter.trim().isEmpty()) ||
			(mold == null || mold.trim().isEmpty())) {
			throw new ValidationException("invalid type or mold");
		}
					
		
		soap.setBarType(BarTypes.valueOf(type));
		soap.setBaseType(BaseTypes.valueOf(butter));
		soap.setMoldStyle(MoldStyle.valueOf(mold));
		
		
		if(barOfSoapService.createSoap(soap)) {
			resp.setCode(200);
			resp.setMessage("Soap added");
			return ResponseEntity.status(HttpStatus.OK).body(resp);			
		}

		resp.setCode(400);
		resp.setMessage("Error adding soap");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}
	
	@PutMapping(value = "/soaps")
	ResponseEntity<ResponseModel> editASoap(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody BarOfSoap soap) {
		
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}
	
	@PutMapping(value = "/soaps2")
	ResponseEntity<ResponseModel> updateSoapCount(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody UpdateSoapBars soap) {
		
		logger.info("calling update soap count");
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}
		
		boolean res = barOfSoapService.updateSoapCounts(soap);
		if(res) {
			resp.setMessage("Soap Updated");
			resp.setCode(200);
		} else {
			resp.setMessage("Not Updated");
			resp.setCode(400);
		}

		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}
	
	@DeleteMapping(value = "/soaps")
	ResponseEntity<ResponseModel> deleteASoap(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody BarOfSoap soap) {
		
		ResponseModel resp = new ResponseModel();
		
		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		if(barOfSoapService.deleteSoap(soap)) {
			resp.setMessage("Soap deleted");
			return ResponseEntity.status(HttpStatus.OK).body(resp);			
		}


		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(resp);
	
	}
	@GetMapping(value = "/soaps2")
	ResponseEntity<ResponseModel> getAllSoapPaged(
			@RequestParam String info) {

		logger.info("calling soaps 2 - all soaps paged");
		ResponseModel resp = new ResponseModel();
		
		int pageNumber = 0;
		int pageSize = 10;
		String[] parts = info.split(":");
		try {
			if( parts.length > 0) {
				pageNumber = Integer.parseInt(parts[0]);
			}
			if( parts.length == 2) {
				pageSize = Integer.parseInt(parts[1]);
			}
		} catch (NumberFormatException e) {
			throw new ValidationException("Invalid page size or number");
		}
		
		List<BarOfSoap> soapList = new ArrayList<BarOfSoap>();
		Pageable paging = PageRequest.of(pageNumber, pageSize);
		Page<BarOfSoap> pageObs = null;

		pageObs = barOfSoapService.getAllSoapsPaged(paging);

		if(pageObs != null) {
			soapList = pageObs.getContent();
			resp.setMessage("list of soaps");
			ArrayList<BarOfSoap> sl = new ArrayList<BarOfSoap>();
			sl.addAll(soapList);
			resp.setListOfSoaps(sl);
			resp.setCode(200);
			resp.setCurrentPage(String.valueOf(pageObs.getNumber()));
			resp.setTotalItems(String.valueOf(pageObs.getTotalElements()));
			resp.setTotalPages(String.valueOf(pageObs.getTotalPages()));

		}
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
	
	
	@GetMapping(value = "/soaps")
	ResponseEntity<ResponseModel> getAllSoap() {
		
		logger.info("calling get all soaps");
		ResponseModel resp = new ResponseModel();

		List<BarOfSoap> soapList = barOfSoapService.getAllSoaps();

		if (soapList != null) {
			resp.setMessage("list of soaps");
			ArrayList<BarOfSoap> sl = new ArrayList<BarOfSoap>();
			sl.addAll(soapList);
			resp.setListOfSoaps(sl);
			resp.setCode(200);
			resp.setMessage("soaps found");
		} else {
			resp.setCode(200);
			resp.setMessage("None found");
		}
	
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}

	@GetMapping(value = "/soaps/{soapName}")
	ResponseEntity<ResponseModel> getOneSoapByName(
			@PathVariable String soapName) {
		
		logger.info("calling get one soap by name");
		
		ResponseModel resp = new ResponseModel();

		BarOfSoap soap = barOfSoapService.getOneBarByName(soapName);
		if(soap != null) {
			resp.setCode(200);
			resp.setMessage("Soap Found");
			resp.setBarOfSoap(soap);	
		} else {
			resp.setCode(404);
			resp.setMessage("Soap not found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}
	
}
