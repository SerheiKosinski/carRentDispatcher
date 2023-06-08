package by.remprofi.repository.sprdata;

import by.remprofi.domain.hiber.HiberPark;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkDataRepository extends JpaRepository<HiberPark, Long> {

    @Cacheable("park")
    List<HiberPark> findByCity(Boolean cityFlag);

}
