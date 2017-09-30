package com.companyname.service.util.comparator;

import java.util.Comparator;
import java.util.Date;

import com.companyname.service.dto.social.SimpleActivityDTO;

public class ActivityComparator implements Comparator<SimpleActivityDTO> {

	@Override
	public int compare(SimpleActivityDTO o1, SimpleActivityDTO o2) {
		Date oldestDate = new Date(Long.MIN_VALUE);
		Date o1Date = oldestDate;
		Date o2Date = oldestDate;

		if (o1.getDate() != null) {
			o1Date = o1.getDate();
		}
		if (o2.getDate() != null) {
			o2Date = o2.getDate();
		}

		return o2Date.compareTo(o1Date);
	}

}
