package com.volunteers.repos;

import com.volunteers.entity.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepo extends CrudRepository<Organisation, Long> {
    Organisation findOrgById(Long id);
    Organisation findOrganisationByCompanyName(String companyName);
}
