package com.lorrymgmtsyst.resource;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lorrymgmtsyst.model.Consignment;
import com.lorrymgmtsyst.model.Driver;
import com.lorrymgmtsyst.model.Lorry;
import com.lorrymgmtsyst.services.ConsignmentServices;
import com.lorrymgmtsyst.services.DriverServices;
import com.lorrymgmtsyst.services.LorryServices;

@SuppressWarnings("unchecked")
@RestController
public class ConsignmentResorces {

	@Autowired
	private ConsignmentServices consignmentService;
	
	@Autowired
	private DriverServices driverService;
	
	@Autowired
	private LorryServices lorryService;
	
	@PostMapping(path = "/consignment")
	public ResponseEntity<?> addConsignment(@RequestBody Consignment consignment){
		Lorry lorry = consignment.getLorry();
		if(lorry.getLorryCapacity()<consignment.getConsignmentWeight()) {
			JSONObject msg = new JSONObject();
			msg.put("error", "Loory selected cannot handle the weight of the consignment");
			return ResponseEntity.badRequest().body(msg);
		}
		else {
			return ResponseEntity.ok(consignment);
		}
	}
	
	@GetMapping(path = "/consignment")
	public ResponseEntity<?> getConsignments(){
			return ResponseEntity.ok(consignmentService.getAllConsignments());
		
	}
	
	@PutMapping(path = "/consignmemt")
	public ResponseEntity<?> updateConsignment(Consignment consignment){
		return ResponseEntity.ok(consignmentService.updateConsignment(consignment));
	}
	
	@DeleteMapping(path = "/consignment")
	public ResponseEntity<?> deleteConsignment(Consignment consignment){
		consignmentService.deleteConsignment(consignment);
		JSONObject msg = new JSONObject();
		msg.put("success", "consignment deleted successfully");
		return ResponseEntity.ok(msg);
	}
	
	@PostMapping(path = "consignment/driver/{id}")
	public ResponseEntity<?> getConsignmentByDriverId(@PathParam("id") int id){
		Optional<Driver> driver = driverService.getDriverById(id);
		if(driver.isPresent()) {
			return ResponseEntity.ok(consignmentService.getConsignmentsByDriver(driver.get()));
		}
		JSONObject msg = new JSONObject();
		msg.put("error", "Driver doesn't exists");
		return ResponseEntity.badRequest().body(msg);
	}
	
	@PostMapping(path = "consignment/lorry/{id}")
	public ResponseEntity<?> getConsignmentByLorryId(@PathParam("id") int id){
		Optional<Lorry> lorry = lorryService.getLorryById(id);
		if(lorry.isPresent()) {
			return ResponseEntity.ok(consignmentService.getConsignmentsByLorry(lorry.get()));
		}
		JSONObject msg = new JSONObject();
		msg.put("error", "Lorry doesn't exists");
		return ResponseEntity.badRequest().body(msg);
	}
	
	
}

