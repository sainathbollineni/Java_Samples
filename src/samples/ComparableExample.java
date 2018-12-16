package samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ComparableDTO implements Comparable<ComparableDTO> {

	private int id;
	private String name;
	private String dept;

	public ComparableDTO() {
	}

	public ComparableDTO(int id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
			ComparableDTO ce = (ComparableDTO) obj;

			if (!this.getName().equals(ce.getName()) || !this.getDept().equals(ce.getDept())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return this.id + this.name.hashCode() + this.dept.hashCode();
	}

	@Override
	public int compareTo(ComparableDTO o) {
		if (this.getName().equals(o.getName())) {
			return this.getDept().compareTo(o.getDept());
		} else {
			return this.getName().compareTo(o.getName());
		}
	}

	@Override
	public String toString() {
		return "ComparableDTO [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}
}

public class ComparableExample {

	public static void main(String args[]) {

		List<ComparableDTO> data = new ArrayList<>();

		data.add(new ComparableDTO(1, "SaiNath", "Software"));
		data.add(new ComparableDTO(2, "Sai", "Engineer"));
		data.add(new ComparableDTO(3, "SaiNath", "Hardware"));
		data.add(new ComparableDTO(4, "Dad", "Farmer"));
		data.add(new ComparableDTO(5, "Mom", "HomeMaker"));

		System.out.println("******************** Natural Sorting By Name/Dept ******************** ");

		Collections.sort(data);

		for (ComparableDTO dto : data) {
			System.out.println(dto);
		}

		System.out.println("******************** Sorting By Dept ******************** ");

		Collections.sort(data, new ComparatorSortByDept());

		for (ComparableDTO dto : data) {
			System.out.println(dto);
		}

		System.out.println("********************  Sorting By Name ******************** ");

		Collections.sort(data, new ComparatorSortByName());

		for (ComparableDTO dto : data) {
			System.out.println(dto);
		}
	}
}