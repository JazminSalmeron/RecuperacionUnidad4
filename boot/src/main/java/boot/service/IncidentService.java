package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.IncidentRepository;
import boot.dao.StudentRepository;
import boot.model.Incident;
import boot.model.Student;


	@Service @Transactional
	public class IncidentService {
		private final IncidentRepository incidentRepository;

		public IncidentService(IncidentRepository incidentRepository) {
			super();
			this.incidentRepository = incidentRepository;
		}
		public List<Incident> findAll(){
			List<Incident> incidents = new ArrayList<Incident>();
			for (Incident incident : incidentRepository.findAll()){
				incidents.add(incident);
			}
			return incidents;
		}
		
		public void save(Incident incident){
			incidentRepository.save(incident);
		}
		
		public void delete(int incidentID){
			incidentRepository.delete(incidentID);
		}
		
		public Incident findIncident(int incidentID){
			return incidentRepository.findOne(incidentID);
		}
	}

		
	