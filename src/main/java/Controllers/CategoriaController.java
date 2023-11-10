package Controllers;

import Entities.Categoria;
import Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")// Brinda o permite el acceso a la API desde distintos orígenes o clientes
@RequestMapping("api/v1/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    /**
     * El metodo ResponseEntity devuelve la petición en formato JSON.
     * Contiene el status de la respuesta HTTP status (OK, NOT FOUND) y un body donde se envian los datos a la aplicación.
     * @return Si el resultado es OK (cod HTTP 200), devuelve el contenido en el body de la respuesta.
     *              - HttpStatus OK (200) Devuelve la lista con todas las Categorias almacenadas en la Base de Datos.
     *              - HttpStatus NOT_FOUND (400) Error, no encontrado.
     */
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    /**
     * El método devuelve la entidad categoria identificada con el id que se envia como variable en el URI
     * @param id de la categoria pedida
     * @return ResponseEntity con el resultado de la operación:
     *              - HttpStatus OK (200) Devuelve la Categoria encontrada.
     *              - HttpStatus NOT_FOUND (400) Error, no encontrado.
     */
    @GetMapping("/{id}")//Metodo PathVariable
    public ResponseEntity<?> getOne( @PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findByID(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    /**
     * Guarda una entidad de tipo Categoria.
     *
     * @param entity La entidad Categoria que se desea guardar, @RequestBody declara que la entidad se encuentra en el body del request
     * @return ResponseEntity con el resultado de la operación:
     *         - HttpStatus OK (200) si la entidad se guarda con éxito. Devuelve la entidad guardada.
     *         - HttpStatus BAD_REQUEST (400) si ocurre algún error durante el proceso. Devuelve un mensaje de error.
     */
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Categoria entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    /**
     * Actualiza una entidad de tipo Categoria por su identificador.
     *
     * @param id     El id de la entidad Categoria que se desea actualizar.
     * @param entity La entidad Categoria con los datos actualizados.
     * @return ResponseEntity con el resultado de la operación:
     *         - HttpStatus OK (200) si la entidad se actualiza con éxito. Devuelve la entidad actualizada.
     *         - HttpStatus BAD_REQUEST (400) si ocurre algún error durante el proceso. Devuelve un mensaje de error.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Categoria entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.update(id,entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoriaService.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}
