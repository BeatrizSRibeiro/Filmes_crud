package filmes_crud.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import filmes_crud.proj.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}