package esCV;

public class Degree {

	private String type_of_degree_achieved;
	private int degree_duration;
	private int degree_grade;

	public Degree(String type_of_degree_achieved, int degree_duration, int degree_grade) {
		this.type_of_degree_achieved = type_of_degree_achieved;
		this.degree_duration = degree_duration;
		this.degree_grade = degree_grade;
	}

	public String getType_of_degree_achieved() {
		return type_of_degree_achieved;
	}

	public int getDegree_duration() {
		return degree_duration;
	}

	public int getDegree_grade() {
		return degree_grade;
	}

	@Override
	public String toString() {
		return "\n--- Degree ---\n type of degree=[" + type_of_degree_achieved + "], degree duration=["
				+ degree_duration + "], degree grade=[" + degree_grade + "]\n";
	}
}
