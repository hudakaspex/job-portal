package com.job.portal.Jobportal.repository.core;

import com.job.portal.Jobportal.models.core.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}