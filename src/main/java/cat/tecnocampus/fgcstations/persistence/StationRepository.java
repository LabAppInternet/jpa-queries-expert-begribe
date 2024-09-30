package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.StationDTO;
import cat.tecnocampus.fgcstations.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, String> {
    @Query("select s FROM Station s")
    List<StationDTO> findAllDTO();

    @Query("SELECT s FROM Station s WHERE s.name = :name")
    Optional<StationDTO> findByIdDTO(String name);
}
