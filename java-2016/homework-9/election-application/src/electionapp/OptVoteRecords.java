package electionapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OptVoteRecords extends VoteRecords implements AutoCloseable {
	
	private FileWriter writer;

	public void openTXT() throws IOException {
		File file = new File(VOTE_LIST);
		writer = new FileWriter(file, true);
	}
	
	public void closeTXT() throws IOException{
		if(writer!=null){
			writer.close();
		}
	}

	@Override
	public void save(VoteList vote) throws IOException {
		
			writer.append(txtFormater.toTXT(vote) + "\n");
		
	}

	@Override
	public void close() throws Exception {
		closeTXT();
	}


}
