package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.technologies.GetAllTechnologiesResponse;

public interface TechnologyService {
	List<GetAllTechnologiesResponse> getAll();
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void update(UpdateTechnologyRequest updateTechnologyRequest)throws Exception;
	void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
}
