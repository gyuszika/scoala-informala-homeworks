package electionapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VoteRecords implements VoteSystem {
	
	protected static final String VOTE_LIST = "votes.txt";
	protected TXTVoteFormatter txtFormater = new TXTVoteFormatter();

	@Override
	public void save(List<VoteList> listOfVotes) throws IOException {
		File file = new File(VOTE_LIST);
		try (FileWriter writer = new FileWriter(file, true)) {
			
			for(VoteList vote :listOfVotes){
			writer.append(txtFormater.toTXT(vote) + "\n");
			}
		}
	}

	@Override
	public List<VoteList> loadAll() throws FileNotFoundException, IOException, ParseException {
		File file = new File(VOTE_LIST);
		ArrayList<VoteList> vote = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			while(line!=null){
				VoteList v = txtFormater.fromTXT(line);
				vote.add(v);
				line = reader.readLine();
			}
		}
		return vote;
	}
	
}
