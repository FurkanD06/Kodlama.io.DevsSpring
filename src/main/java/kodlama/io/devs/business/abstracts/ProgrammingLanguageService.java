package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguages.GetAllProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguageResponse> getAll();
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest)throws Exception;
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest)throws Exception;
	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest)throws Exception;
}
