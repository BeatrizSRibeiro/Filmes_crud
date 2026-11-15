package filmes_crud.proj.service;

import filmes_crud.proj.model.Filme;
import filmes_crud.proj.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public List<Filme> listar() {
        return repository.findAll();
    }

    public Filme buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Filme não encontrado: " + id));
    }

    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

   public void excluir(Long id) {
    repository.deleteById(id);
}
}