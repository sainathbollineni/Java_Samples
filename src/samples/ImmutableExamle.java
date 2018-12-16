package samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class CustomImmutableExample implements Cloneable {

	private final int id;

	private final String name;

	private final String dept;

	private Address address;

	private ArrayList<Address> oldAddresses;

	public CustomImmutableExample(int id, String name, String dept, Address address, ArrayList<Address> oldAddresses) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.address = address;
		this.oldAddresses = oldAddresses;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

	public List<Address> getOldAddresses() {
		return (List<Address>) Collections.unmodifiableCollection(oldAddresses);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((oldAddresses == null) ? 0 : oldAddresses.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomImmutableExample other = (CustomImmutableExample) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oldAddresses == null) {
			if (other.oldAddresses != null)
				return false;
		} else if (!oldAddresses.equals(other.oldAddresses))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomImmutableExample [id=" + id + ", name=" + name + ", dept=" + dept + ", address=" + address
				+ ", oldAddresses=" + oldAddresses + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class ImmutableExamle {

	public static void main(String args[]) throws CloneNotSupportedException {

		Address a = new Address();
		a.setLocation("WhiteFiled");
		a.setNearBy("Satya Sai Hospital");
		a.setState("Karnataka");

		ArrayList<Address> oldAddress = new ArrayList<>();
		oldAddress.add(a);

		CustomImmutableExample ce = new CustomImmutableExample(1, "Sai", "Software", a, oldAddress);
		System.out.println(ce.getAddress().getLocation());
		ce.getAddress().setLocation("Near Mercedes");
		System.out.println(ce.getAddress().getLocation());

		System.out.println("************************************");

		System.out.println(ce.getOldAddresses().get(0).getState());

		ce.getOldAddresses().get(0).setState("Andhra Pradesh");

		System.out.println(ce.getOldAddresses().get(0).getState());
	}
}