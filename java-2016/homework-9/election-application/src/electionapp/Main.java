package electionapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.SynchronousQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		
		try (OptVoteRecords repo = new OptVoteRecords()) {
			repo.openTXT();
			ElectionBooth records = new ElectionBooth(repo);
			List<VoteList> listOfVotes = new ArrayList<VoteList>();
			listOfVotes.add(new VoteList(new Date(),"1982037357397", "Dick Dastardly", Candidate.MUTTLEY));
			listOfVotes.add(new VoteList(new Date(),"1982037357397", "Dick Dastardly", Candidate.MUTTLEY));
			listOfVotes.add(new VoteList(new Date(),"1682033457397", "Burt Reynolds", Candidate.MR_BEAN));
			listOfVotes.add(new VoteList(new Date(),"0977187368992", "Ronaldo", Candidate.SPIRT_MONA));
			listOfVotes.add(new VoteList(new Date(),"8889097263791", "Britney Spears", Candidate.A_TREE));
			listOfVotes.add(new VoteList(new Date(),"9555682954009", "Stevie Wonder",null));
			records.save(listOfVotes);
		
			//Map<Candidate, Integer> report = records.generateVote();
		//	records.toString();
			//for (Entry<Candidate, Integer> entry : report.entrySet()) {
			//	VoteList votelist =(entry.getKey());
			//	if (candidate.)
				
			//	System.out.println(candidate.name() + " - " + entry.getValue());
			List<String> nameOfTheVoters =new ArrayList<String>();
			
			for(VoteList vote :listOfVotes){
				if (vote.getCandidate() == null){
					
					System.out.println("The voter with the name "+ vote.getCitizenName() + "has no candidate choosen.");
						
				}
				if (nameOfTheVoters.contains(vote.getCitizenName())){
					System.out.println("The voter with the name "+ vote.getCitizenName() + "has a duplicated vote");
				}
				else
				{
					nameOfTheVoters.add(vote.getCitizenName());
				}
			}
			
		}

	}

}
