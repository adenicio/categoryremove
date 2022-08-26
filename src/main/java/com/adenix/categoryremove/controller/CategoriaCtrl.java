package com.adenix.categoryremove.controller;
import com.adenix.categoryremove.domain.Categoria;
import com.adenix.categoryremove.requests.CategoriaPostReqBody;
import com.adenix.categoryremove.requests.CategoriaPutReqBody;
import com.adenix.categoryremove.service.CategoriaServ;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("categoria")
@Log4j2
@RequiredArgsConstructor
public class CategoriaCtrl {
    @Autowired
    private final CategoriaServ categoriaServ;

    @GetMapping
    public ResponseEntity<List<Categoria>> listAll(){
        return ResponseEntity.ok(categoriaServ.listAll());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){

        categoriaServ.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
