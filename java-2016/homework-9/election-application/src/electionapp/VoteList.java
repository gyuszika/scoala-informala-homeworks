package electionapp;

import java.util.Date;

public class VoteList {

	private Date date;
	private String cnp;
	private String citizenName;
	private Candidate candidate;
	private int vote;

	public String getCnp() {
		return cnp;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public Date getDate() {
		return date;
	}

	public int getVote() {
		return vote;
	}

	public VoteList(Date date, String cnp, String citizenName, Candidate candidate) {
		this.date = date;
		this.cnp = cnp;
		this.citizenName = citizenName;
		this.candidate = candidate;
		//this.vote = vote;
	}

	@Override
	public String toString() {
		return "[" + date + ": " + cnp + ", " + citizenName + ", Voted: " + candidate + "number of votes: " + vote
				+ "]";
	}

}
