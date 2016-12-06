package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.DoramaRepository;
import boot.dao.StudentRepository;
import boot.model.Dorama;
import boot.model.Student;


	@Service @Transactional
	public class DoramaService {
		private final DoramaRepository doramaRepository;

		public DoramaService(DoramaRepository doramaRepository) {
			super();
			this.doramaRepository = doramaRepository;
		}
		public List<Dorama> findAll(){
			List<Dorama> doramas = new ArrayList<Dorama>();
			for (Dorama dorama : doramaRepository.findAll()){
				doramas.add(dorama);
			}
			return doramas;
		}
		
		public void save(Dorama dorama){
			doramaRepository.save(dorama);
		}
		
		public void delete(int doramaID){
			doramaRepository.delete(doramaID);
		}
		
		public Dorama findDorama(int doramaID){
			return doramaRepository.findOne(doramaID);
		}
	}

		
	