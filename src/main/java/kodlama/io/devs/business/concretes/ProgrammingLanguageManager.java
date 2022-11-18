package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguages.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();

		List<GetAllProgrammingLanguageResponse> languageResponse = new ArrayList<GetAllProgrammingLanguageResponse>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {

			GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			languageResponse.add(responseItem);

		}
		return languageResponse;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if (createProgrammingLanguageRequest.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez.");
		}
		else if(isNameExist(createProgrammingLanguageRequest.getName())) {
			throw new Exception("Programlama dili tekrar edemez.");
		}
		else {
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setName(createProgrammingLanguageRequest.getName());
			programmingLanguageRepository.save(programmingLanguage);
		}

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(updateProgrammingLanguageRequest.getId()).get();
		if (isNameExist(updateProgrammingLanguageRequest.getName())) {
			throw new Exception("Bu dil zaten kayıtlı");
		}
		if (isNameEmpty(updateProgrammingLanguageRequest.getName())) {
			throw new Exception("Dil ismi boş geçilemez");
		}
		
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		this.programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
		if (!isIdExist(deleteProgrammingLanguageRequest.getId())) {
			throw new Exception("'Id' bulunamadı");
		}
		
		this.programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());

	}
	
	private boolean isNameExist(String name) {
		for (GetAllProgrammingLanguageResponse language : getAll()) {
			if (name.equals(language.getName())) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isIdExist(int id) {
		for (GetAllProgrammingLanguageResponse language : getAll()) {
			if (language.getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isNameEmpty(String name) {
		if(name.isEmpty()) return true;
		
		return false;
	}

}
