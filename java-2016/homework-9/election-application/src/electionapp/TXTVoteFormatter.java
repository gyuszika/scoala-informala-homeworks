package electionapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TXTVoteFormatter {

	private static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("yyyy-MMM-dd hh:mm");

	public String toTXT(VoteList vote) {
		return DATE_FORMATER.format(vote.getDate()) + "," + vote.getCnp() + "," + vote.getCitizenName() + ","
				+ vote.getCandidate();

	}

	public VoteList fromTXT(String line) throws ParseException {
		String[] tokens = line.split(",");
		Date d = DATE_FORMATER.parse(tokens[0]);
		Candidate c = Candidate.valueOf(tokens[3]);
		return new VoteList(d, tokens[1], tokens[2], c);
	}

}
