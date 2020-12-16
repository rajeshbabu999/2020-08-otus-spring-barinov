package org.library.services;

import org.library.exceptions.GenreNotFoundException;
import org.library.exceptions.GenreNotFoundException;
import org.library.models.Genre;
import org.library.models.Genre;
import org.library.repositories.GenreRepository;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    
    final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre findById(String id) throws GenreNotFoundException {
        return genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(String.format("Genre with id: %s not found", id)));
    }

    @Override
    public void deleteById(String id) throws GenreNotFoundException {
        if (genreRepository.findById(id).isEmpty()) {
            throw new GenreNotFoundException(String.format("Genre with id: %s not found", id));
        }
        genreRepository.deleteById(id);
    }
}
