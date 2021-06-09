package com.slokam.healthcare.service;

import java.util.List;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;

public interface IPatientService {
	 void patientRegistration(Patient patient);
	 List<Patient> patientSearchPojo(PatientSearchPojo searchPojo);
	 List<Patient> getAllPatient();
	 Patient getPatientById(Integer id);
}
