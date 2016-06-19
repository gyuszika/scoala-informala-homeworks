package electionapp;

import java.util.List;

public interface VoteSystem {
	
	void save(List<VoteList> vote) throws Exception;
	List<VoteList> loadAll() throws Exception;

}
