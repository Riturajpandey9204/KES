package in.jt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jt.entity.CaseworkerEntity;

public interface CaseworkerEntityRepository extends JpaRepository<CaseworkerEntity, Serializable> {

}
