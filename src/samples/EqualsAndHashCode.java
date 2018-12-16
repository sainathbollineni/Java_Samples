package samples;

public class EqualsAndHashCode {

	private int id;
	private String name;
	private String dept;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public boolean equals(Object obj) {

		if (null == obj || this.getClass() != obj.getClass()) {
			return false;
		} else if (this == obj) {
			return true;
		} else {

			EqualsAndHashCode dto = (EqualsAndHashCode) obj;

			if (!this.name.equals(dto.getName()) || !this.getDept().equals(dto.getDept())) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		return (this.id + this.name.hashCode() + this.dept.hashCode());
	}

}