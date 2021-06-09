package com.slokam.healthcare.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.exception.UserHealthCareException;
import com.slokam.healthcare.pojo.PatientSearchPojo;
import com.slokam.healthcare.service.IPatientService;

@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired
	private IPatientService patientService;
	@Value("${app.file.upload.location}")
	private String uploadLocation;
	@PostMapping("saveImage")
	public ResponseEntity<String> saveImage(MultipartFile patientImage) throws UserHealthCareException {
		String name=System.currentTimeMillis()+"-"+patientImage.getOriginalFilename();
		try {
			patientImage.transferTo(new File(uploadLocation+name));
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			throw new UserHealthCareException("please check your file",90000,e) ;
		}
		return new ResponseEntity<String>(name,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient){
		patientService.patientRegistration(patient);
		return new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
	}
		@PostMapping("/search") 
		public ResponseEntity<List<Patient>> search(@RequestBody PatientSearchPojo serachPojo){
			List<Patient> pList=patientService.patientSearchPojo(serachPojo);
			return ResponseEntity.ok(pList);
	}
		@GetMapping("/all")
		public 	ResponseEntity<List<Patient>> getAll(){
		List<Patient> patientList=patientService.getAllPatient();
		return ResponseEntity.ok(patientList);
	}
		@GetMapping("/byId/{id}")
		public ResponseEntity<Patient> getPatientById(@PathVariable Integer id){
			Patient p=patientService.getPatientById(id);
			 return ResponseEntity.ok(p);
		}
		// 8 feature
		// Get all EvenPatients on bases of Patient info
		@GetMapping("/allEven")
		public 	ResponseEntity<List<Patient>> getAllEvenPatient(){
		//List<Patient> patientList=patientService.getAllPatient();
		List<Patient> patientList=patientService.getAllPatient().stream().filter(p->p.getId()%2==0).collect(Collectors.toList());
		return ResponseEntity.ok(patientList);
	}	// Get all Patients on bases of PatientAge info
		@GetMapping("/allPatientsByAge")
		public 	ResponseEntity<List<Patient>> getAllPatientByAge(){
		//List<Patient> patientList=patientService.getAllPatient();
		List<Patient> patientList=patientService.getAllPatient().stream().filter(p->p.getAge()>=30).collect(Collectors.toList());
		return ResponseEntity.ok(patientList);
	}	
		@GetMapping("/allPatientsByName/{name}")
		public 	ResponseEntity<List<String>> getAllPatientByName(@PathVariable String name){
		//List<Patient> patientList=patientService.getAllPatient();
			Function<Patient, String> f=(p)->{
					if(p.getName().equals(name)) {
//					String s=p.getName();	
					}
					return p.getName();};			
		List<String> patientList=patientService.getAllPatient().stream().map(f).collect(Collectors.toList());
		return ResponseEntity.ok(patientList);
	}	
}
