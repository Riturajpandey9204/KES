package in.jt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jt.entity.EligibilityDeterminationEntity;

public interface EligibilityDeterminationEntityRepository extends JpaRepository<EligibilityDeterminationEntity, Serializable> {

}
