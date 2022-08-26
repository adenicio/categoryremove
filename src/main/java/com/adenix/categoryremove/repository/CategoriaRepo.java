package com.adenix.categoryremove.repository;
import com.adenix.categoryremove.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria,Long>{

}