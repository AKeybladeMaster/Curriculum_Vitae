package esCV;

import java.util.Date;

public class WorkExperience extends Experience {

	private String company_name;
	private int salary;
	private boolean is_course_updated;
	private String type_of_course_update;

	public WorkExperience(String id, Date exp_start_date, Date exp_end_date, String voice_description,
			String company_name, int salary, boolean is_course_updated, String type_of_course_update) {
		super(id, exp_start_date, exp_end_date, voice_description);
		this.company_name = company_name;
		this.salary = salary;
		this.is_course_updated = is_course_updated;
		this.type_of_course_update = type_of_course_update;
	}

	public String getCompany_name() {
		return company_name;
	}

	public int getSalary() {
		return salary;
	}

	public boolean isCourse_updated() {
		return is_course_updated;
	}

	public String getType_of_course_update() {
		return type_of_course_update;
	}

	public String courseUpdateExists() {
		if (true == isCourse_updated()) {
			return "Yes";
		}
		return "No";
	}

	public String typeOfCourseUpdate() {
		if (type_of_course_update != null) {
			return type_of_course_update;
		}
		return "No one";
	}

	@Override
	public String toString() {
		return super.toString() + "\n--- Work experience ---\n company name=[" + company_name + "], salary=[" + salary
				+ "]\n is course updated=[" + courseUpdateExists() + "], type of course update=[" + typeOfCourseUpdate()
				+ "]\n";
	}

}
