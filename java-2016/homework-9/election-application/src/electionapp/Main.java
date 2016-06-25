package electionapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws Exception {

		try (OptVoteRecords repo = new OptVoteRecords()) {
			new Thread(){
				@Override
				public void run() {
					synchronized(repo){
						System.out.println("Voting started!");
					}
				}
			}.start();
			
			repo.openTXT();

			ElectionBooth records = new ElectionBooth(repo);
			List<VoteList> listOfVotes = new ArrayList<VoteList>();

			listOfVotes.add(new VoteList(new Date(), "1982037357397", "Dick Dastardly", Candidate.MUTTLEY));
			listOfVotes.add(new VoteList(new Date(), "1982037357397", "Dick Dastardly", Candidate.MUTTLEY));
			listOfVotes.add(new VoteList(new Date(), "1682033457397", "Burt Reynolds", Candidate.MR_BEAN));
			listOfVotes.add(new VoteList(new Date(), "1911217125789", "Bandy", Candidate.MR_BEAN));
			listOfVotes.add(new VoteList(new Date(), "0977187368992", "Ronaldo", Candidate.SPIRT_MONA));
			listOfVotes.add(new VoteList(new Date(), "8889097263791", "Britney Spears", Candidate.A_TREE));
			listOfVotes.add(new VoteList(new Date(), "9555682954009", "Stevie Wonder", null));
			listOfVotes.add(new VoteList(new Date(), "1865544868465", "Gyulus", Candidate.MR_BEAN));

			records.save(listOfVotes);

			Map<Candidate, Integer> voteCount = countCandidateVotes(listOfVotes);
			System.out.println("Votes per candidate: " + voteCount);

			Candidate mostVotedCandidate = getMostCommonCandidate(voteCount);
			System.out.println("The winner candidate is: " + mostVotedCandidate);

			List<String> nameOfTheVoters = new ArrayList<String>();
			List<String> numberOfInvalidVotes = new ArrayList<>();

			for (VoteList vote : listOfVotes) {

				if (vote.getCandidate() == null) {
					numberOfInvalidVotes.add(vote.getCitizenName());
					System.out.println(vote.getCitizenName() + " has no candidate choosen.");

				}
				if (nameOfTheVoters.contains(vote.getCnp())) {
					System.out.println(vote.getCitizenName()
							+ " has broken the rules and will be fined. All of his votes are invalidated.");
					numberOfInvalidVotes.add(vote.getCitizenName());

				} else {
					nameOfTheVoters.add(vote.getCnp());
				}
			}
			int validVotes = nameOfTheVoters.size() - numberOfInvalidVotes.size();
			int dupeVoter = numberOfInvalidVotes.size();

			System.out.println("Validated votes: " + validVotes);
			System.out.println("Invalid votes: " + dupeVoter);
		}

	}

	private static Map<Candidate, Integer> countCandidateVotes(List<VoteList> listOfVotes) {
		Map<Candidate, Integer> inventoryCount = new HashMap<Candidate, Integer>();
		Iterator<VoteList> iterator = listOfVotes.iterator();

		while (iterator.hasNext()) {
			VoteList p = iterator.next();
			Candidate pt = p.getCandidate();

			if (inventoryCount.containsKey(pt)) {
				int counter = inventoryCount.get(pt);
				inventoryCount.put(pt, ++counter);
			} else {
				inventoryCount.put(pt, 1);
			}
		}
		return inventoryCount;
	}

	private static Candidate getMostCommonCandidate(Map<Candidate, Integer> inventoryCount) {
		int maxCount = 0;
		Candidate mostVotedCandidate = null;
		for (Entry<Candidate, Integer> entry : inventoryCount.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				mostVotedCandidate = entry.getKey();
			}
		}
		return mostVotedCandidate;
	}

}
