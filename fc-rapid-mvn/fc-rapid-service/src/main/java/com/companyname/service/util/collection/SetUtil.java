package com.companyname.service.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.companyname.service.dto.social.SimpleActivityDTO;
import com.companyname.service.util.comparator.ActivityComparator;

public class SetUtil {

	public static TreeSet<SimpleActivityDTO> getFirstActivities(int n, TreeSet<SimpleActivityDTO> treeSet) {
		TreeSet<SimpleActivityDTO> subset = new TreeSet<SimpleActivityDTO>(new ActivityComparator());
		List<SimpleActivityDTO> list = new ArrayList<>(treeSet);
		if (treeSet.size() < n) {
			return treeSet;
		}
		subset.addAll(list.subList(0, n));
		return subset;
	}

}
