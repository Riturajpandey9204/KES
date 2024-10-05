package in.jt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jt.entity.CaseworkerEntity;

public interface CaseworkerEntityRepository extends JpaRepository<CaseworkerEntity, Serializable> {
	public abstract CaseworkerEntity findByCwEmailIdAndCwPassword(String email,String password);
}
