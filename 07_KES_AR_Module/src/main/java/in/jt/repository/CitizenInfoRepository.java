package in.jt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jt.entity.CitizenInfo;

public interface CitizenInfoRepository extends JpaRepository<CitizenInfo, Serializable> {

}
