package com.companyname.service.transformer;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.platform.Category;

@Component
public class CategoryTransformer {

	public Set<String> toStrings (Set<Category> categories){
		Set<String> stringCategories = new HashSet<>();
			
		for (Category category : categories) {
			stringCategories.add(category.getName());
		}
				
		return stringCategories;
	}
}
