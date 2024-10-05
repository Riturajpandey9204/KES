package in.jt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jt.entity.CitizenDataEntity;

public interface CitizenDataInfoRepository extends JpaRepository<CitizenDataEntity, Serializable> {

	public abstract CitizenDataEntity findByCitizenSsn(long ssn);
}
