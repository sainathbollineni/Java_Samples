package samples;

import java.util.Comparator;

public class ComparatorExample {

}

class ComparatorSortByDept implements Comparator<ComparableDTO> {

	@Override
	public int compare(ComparableDTO o1, ComparableDTO o2) {

		if (o1.equals(o2)) {
			return 0;
		} else {
			return o1.getDept().compareTo(o2.getDept());
		}
	}
}

class ComparatorSortByName implements Comparator<ComparableDTO> {

	@Override
	public int compare(ComparableDTO o1, ComparableDTO o2) {

		if (o1.equals(o2)) {
			return 0;
		} else {
			return o1.getName().compareTo(o2.getName());
		}
	}
}