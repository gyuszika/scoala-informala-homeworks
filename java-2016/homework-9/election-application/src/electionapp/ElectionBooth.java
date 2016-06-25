package electionapp;

import java.util.List;

public class ElectionBooth {

	private VoteSystem repo;

	public ElectionBooth(VoteSystem repo) {
		super();
		this.repo = repo;
	}

	public void save(List<VoteList> listOfVotes) throws Exception {

		repo.save(listOfVotes);
	}

}
