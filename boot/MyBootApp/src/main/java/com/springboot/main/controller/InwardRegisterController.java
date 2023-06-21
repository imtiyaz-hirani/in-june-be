package com.springboot.main.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Godown;
import com.springboot.main.model.InwardRegister;
import com.springboot.main.model.Product;
import com.springboot.main.model.Supplier;
import com.springboot.main.service.GodownService;
import com.springboot.main.service.InwardRegisterService;
import com.springboot.main.service.ProductService;
import com.springboot.main.service.SupplierService;

@RestController
@RequestMapping("/inwardregister")
public class InwardRegisterController {

	@Autowired
	private ProductService productService; 
	
	@Autowired
	private GodownService godownService;
	
	@Autowired
	private SupplierService supplierService; 
	
	@Autowired
	private InwardRegisterService inwardRegisterService;
	
	@PostMapping("/add/{productId}/{godownId}/{supplierId}")
	public ResponseEntity<?> postInwardRegister(@RequestBody InwardRegister inwardRegister,
								   @PathVariable("productId") int productId,
								   @PathVariable("godownId") int godownId,
								   @PathVariable("supplierId") int supplierId) {
		
		/* Validate Ids and fetch Objects */
		
		Product product = productService.getById(productId);
		if(product == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Invalid product ID given");
		
		Godown godown = godownService.getById(godownId);
		if(godown == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Invalid godown ID given");
		
		Supplier supplier  = supplierService.getById(supplierId);
		if(supplier == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Invalid supplier ID given");
		
		/* Attach all objects to inwardRegister */
		inwardRegister.setProduct(product);
		inwardRegister.setGodown(godown);
		inwardRegister.setSupplier(supplier);
		
		inwardRegister.setDateOfSupply(LocalDate.now());
		
		/* save inwardRegister object  */
		inwardRegister = inwardRegisterService.insert(inwardRegister);
		return ResponseEntity.status(HttpStatus.OK)
				.body(inwardRegister);
	}
	
}
