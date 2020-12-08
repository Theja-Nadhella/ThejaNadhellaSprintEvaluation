package com.cg.timecard.services;

/**Author: Theja Nadhella 
 * Project Desc: Time Card Service
 * Class Desc: This class provides validation for the input*/
 
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
@Service
public class MapValidationErrorService {
	/**
	 * this method performs validation for the provided input
	 * @param result-defines an object of binding result
	 * @return response entity
	 */
	public ResponseEntity<?> mapValidationService(BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMap=new HashMap<>();
			for(FieldError fieldError:result.getFieldErrors()) {
				errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
				
			}
			return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
