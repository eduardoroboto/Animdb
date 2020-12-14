package com.mdb.Animdb.Controller.productions;

import com.mdb.Animdb.model.objects.Casting;
import com.mdb.Animdb.model.productions.ProductionModel;
import com.mdb.Animdb.model.services.AdminService;
import com.mdb.Animdb.model.services.CastingService;
import com.mdb.Animdb.model.services.ProductionService;
import com.mdb.Animdb.model.services.TagsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// TODO Modificar os returns para retornar mensagens HTTP
// TODO  Adicionar algo que permita adicionar mais tags E atores pelo sistema

@RestController
@RequestMapping("/production")
public class ProductionController {

    ProductionService productionService;
    CastingService castingService;
    TagsService tagsService;
    AdminService adminService;



    public ProductionController(ProductionService productionService, AdminService adminService, CastingService castingService, TagsService tagsService){
        this.productionService = productionService;
        this.adminService = adminService;
        this.castingService = castingService;
        this.tagsService = tagsService;

    }

    @PostMapping
    public void postProduction(@RequestBody  ProductionModel production,
                         @RequestHeader Integer session_id) {

        if(adminService.getAdmin(session_id).isPresent()){
            productionService.save(production);
            System.out.println("Adding +" + production);
        }
    }

    @PostMapping("/cast/{id}")
    public void postProductionCasting(@PathVariable(name = "id") Integer id,
                                      @RequestParam(name = "cast") List<String> casting,
                                      @RequestHeader Integer session_id) {

        if(adminService.getAdmin(session_id).isPresent()){
            castingService.addMore(id,casting);
            System.out.println("Adding cast member +" + casting + "to  production with ID --> " + id);
        }
    }

    @PostMapping("/tag/{id}")
    public void postProductionTags(@PathVariable(name= "id") Integer id,
                                   @RequestParam(name = "tags") List<String> tags,
                                   @RequestHeader Integer session_id) {

        if(adminService.getAdmin(session_id).isPresent()){
            tagsService.addMore(id,tags);
            System.out.println("Adding this+" + tags + "to producition with ID --> " + id);
        }
    }

    @GetMapping
    public List<ProductionModel> getAll() {

        return productionService.listAll();

    }

    @GetMapping("/{id}")
    public Optional<ProductionModel> getById(@PathVariable("id") Integer id) {

        return productionService.getProductionById(id);

    }

    @GetMapping("/anime")
    public List<ProductionModel> getAnime(@RequestParam(value = "title", required = false) String title,
                                          @RequestParam(value = "author", required = false) String author,
                                          @RequestParam(value = "status", required = false) String status){

        return productionService.searchByInfo(title,author,status,"anime");

    }

    @GetMapping("/movie")
    public List<ProductionModel> getMovie(@RequestParam(value = "title", required = false) String title,
                                          @RequestParam(value = "author", required = false) String author,
                                          @RequestParam(value = "status", required = false) String status){

        return productionService.searchByInfo(title,author,status,"movie");

    }

    @GetMapping("/serie")
    public List<ProductionModel> getSerie(@RequestParam(value = "title", required = false) String title,
                                          @RequestParam(value = "author", required = false) String author,
                                          @RequestParam(value = "status", required = false) String status){

        return productionService.searchByInfo(title,author,status,"serie");

    }

    @GetMapping("/tag")
    public List<ProductionModel> getByTags(@RequestParam(value = "tags") List<String> tags){

        return productionService.searchByTags(tags);

    }

    @GetMapping("/cast")
    public List<ProductionModel> getProductionCasting(@RequestParam(name = "cast") List<String> casting) {
        System.out.println("Getting movies with --> " + casting);
        return productionService.searchByCast(casting);
    }

    @GetMapping("/info")
    public List<ProductionModel> getByInfo(@RequestParam(value = "title", required = false) String title,
                                           @RequestParam(value = "author", required = false) String author,
                                           @RequestParam(value = "status", required = false) String status,
                                           @RequestParam(value = "format" ,required = false) String format){

        return productionService.searchByInfo(title,author,status,format);

    }

    @PutMapping("/{id}") //http://localhost:8080/production?id=021
    public void changeProduction(@PathVariable("id") Integer id,
                                  @RequestHeader Integer session_id,
                                  @RequestBody ProductionModel production) {

        if(adminService.getAdmin(session_id).isPresent()){
            productionService.update(id,production);
            System.out.println("Changing production of ID --> +" + id + " by the Admin " + session_id);
        }
    }

    @PutMapping("/cast/{id}") //http://localhost:8080/production?id=021
    public void changeCast(@PathVariable("id") Integer id,
                                 @RequestHeader Integer session_id,
                                 @RequestBody Casting cast) {

        if(adminService.getAdmin(session_id).isPresent()){
            castingService.update(id,cast);
            System.out.println("Changing cast of ID --> +" + id + " by the Admin " + session_id);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteProduction(@PathVariable("id") Integer id,
                                  @RequestHeader("session_id") Integer session_id) {

        if( adminService.getAdmin(session_id).isPresent() ){
            productionService.delete(id);
            System.out.println("Admin Delete Production of --> " + " ID = " + id);
        }

    }


    @DeleteMapping("/tag/{id}")
    public void deleteTagsById(@PathVariable("id") Integer id){

        tagsService.deleteById(id);

    }

    @DeleteMapping("/cast/{id}")
    public void deleteCastingById(@PathVariable("id") Integer id) {
        castingService.deleteById(id);
    }




}
