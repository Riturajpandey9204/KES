package in.jt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jt.entity.PlansInfoEntity;

public interface PlansInfoEntityRepository extends JpaRepository<PlansInfoEntity, Serializable> {

}
