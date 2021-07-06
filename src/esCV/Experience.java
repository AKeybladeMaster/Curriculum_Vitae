package esCV;

import java.util.Date;

public abstract class Experience implements Comparable<Experience> {

	private String id;
	private Date exp_start_date;
	private Date exp_end_date;
	private String brief_description;

	public Experience(String id, Date exp_start_date, Date exp_end_date, String brief_description) {
		this.id = id;
		this.exp_start_date = exp_start_date;
		this.exp_end_date = exp_end_date;
		this.brief_description = brief_description;
	}

	public String getId() {
		return id;
	}
	
	public Date getExp_start_date() {
		return exp_start_date;
	}

	public Date getExp_end_date() {
		return exp_end_date;
	}

	public String getBrief_description() {
		return brief_description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Experience))
			return false;
		Experience other = (Experience) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Experience e) {
		return this.exp_start_date.compareTo(e.getExp_start_date());
	}

	@Override
	public String toString() {
		return "\n EXPERIENCE ID=[" + id + "]\n experience start date=[" + exp_start_date + "], experience end date=[" + exp_end_date + "]\n"
				+ " brief description: " + brief_description + "\n";
	}
}
