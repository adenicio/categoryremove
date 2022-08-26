package com.adenix.categoryremove.service;
import com.adenix.categoryremove.domain.Categoria;
import com.adenix.categoryremove.exception.BadRequestException;
import com.adenix.categoryremove.mapper.CategoriaMapper;
import com.adenix.categoryremove.repository.CategoriaRepo;
import com.adenix.categoryremove.requests.CategoriaPostReqBody;
import com.adenix.categoryremove.requests.CategoriaPutReqBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoriaServ{
    private final CategoriaRepo categoriaRepo;
    public List<Categoria> listAll(){
        return categoriaRepo.findAll();

    }
    public Categoria findById(long id){
        return  categoriaRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Categoria não encontrado"));

    }
    public Categoria findByIdThrowBadRequestException (long id){
        return categoriaRepo.findById(id)
                .orElseThrow(() -> new BadRequestException("Categoria Id not found."));

    }

    public Page<Categoria> listAll(Pageable pageable) {
        return categoriaRepo.findAll(pageable);

    }

    public List<Categoria> listAllNonPageable() {
        return categoriaRepo.findAll();

    }

    public void delete(long id) {

        categoriaRepo.delete(findByIdThrowBadRequestException(id));
    }
}