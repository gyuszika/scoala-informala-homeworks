package electionapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionBooth {
	
private VoteSystem repo;
	
	public ElectionBooth(VoteSystem repo) {
		super();
		this.repo = repo;
	}

	public void save(List<VoteList> listOfVotes) throws Exception{

			repo.save(listOfVotes);
		
		
	}
	
	public Map<Candidate, Integer> generateVote() throws Exception{
		
		List<VoteList> vote = repo.loadAll();
		HashMap<Candidate, Integer> report = new HashMap<>();
		int totalVotes = computeTotalVotes(vote);
		for(Candidate candidate : Candidate.values()){
			int candidateVoted = computeTotalForCandidate(candidate, vote);
			report.put(candidate, calculateVotes(totalVotes, candidateVoted));
		}
		return report;
	}

	private int calculateVotes(int max, int actual) {
		return actual + max;
	}
	

	private int computeTotalForCandidate(Candidate candidate, List<VoteList> vote) {
		int candidateVoted = 0;
		for(VoteList e : vote){
			if(candidate.equals(e.getCandidate())){
				candidateVoted++ ;
			}
		}
		return candidateVoted;
	}

	private int computeTotalVotes(List<VoteList> vote) {
		int totalVotes = 0;
		for(VoteList e : vote){
			totalVotes += e.getVote();
		}
		return totalVotes;
	}

}
