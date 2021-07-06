package esCV;

import java.util.Date;

public class StudyExperience extends Experience {

	private String school_name;
	private int years_of_study;
	private Degree degree;

	public StudyExperience(String id, Date exp_start_date, Date exp_end_date, String voice_description,
			String school_name, int years_of_study, Degree degree) {
		super(id, exp_start_date, exp_end_date, voice_description);
		this.school_name = school_name;
		this.years_of_study = years_of_study;
		this.degree = degree;
	}

	public String getSchool_name() {
		return school_name;
	}

	public int getYears_of_study() {
		return years_of_study;
	}

	public Degree getDegree() {
		return degree;
	}

	public String degreeExists() {
		if (null != degree) {
			return "Yes";
		}
		return "No";
	}

	public String typeOfDegree() {
		if (degree != null)
			return degree.toString();
		return "";
	}

	@Override
	public String toString() {
		return super.toString() + "\n--- Study Experience ---\n school name=[" + school_name + "], years of study=["
				+ years_of_study + "], degree=[" + degreeExists() + "]\n" + typeOfDegree();
	}
}
