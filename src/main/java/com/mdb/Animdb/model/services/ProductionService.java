package com.mdb.Animdb.model.services;

import com.mdb.Animdb.model.productions.ProductionModel;
import com.mdb.Animdb.model.repositories.ProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public ProductionModel save(ProductionModel production) {
        return productionRepository.save(production);
    }

    public void delete(Integer id) {

        productionRepository.deleteById(id);

    }

    public void patch(Integer id, ProductionModel newProduction) {
        Optional<ProductionModel> productionOptional = productionRepository.findById(id);
        if (productionOptional.isPresent() && newProduction != null) {
            ProductionModel production = productionOptional.get();

            if (newProduction.getTitle() != null && !newProduction.getTitle().equals("")) {

                production.setTitle(newProduction.getTitle());
            }
            if (newProduction.getAuthor() != null) {

                production.setAuthor(newProduction.getAuthor());
            }
            if (newProduction.getDuration() != null) {
                production.setDuration(newProduction.getDuration());
            }
            if (newProduction.getEpisodes() != null) {
                production.setEpisodes(newProduction.getEpisodes());
            }
            if (newProduction.getFormat() != null) {

                production.setFormat(newProduction.getFormat());
            }
            if (newProduction.getRating() != null) {

                production.setRating(newProduction.getRating());
            }

            if (newProduction.getReleaseDate() != null) {

                production.setReleaseDate(newProduction.getReleaseDate());
            }
            if (newProduction.getStatus() != null) {

                production.setStatus(newProduction.getStatus());
            }

            if (newProduction.getSynopsis() != null) {

                production.setSynopsis(newProduction.getSynopsis());
            }

            productionRepository.save(production);

        }

    }

    public void update(Integer id, ProductionModel newProduction) {
        Optional<ProductionModel> productionOptional = productionRepository.findById(id);
        if (productionOptional.isPresent()) {
            ProductionModel production = productionOptional.get();
            production.setTitle(newProduction.getTitle());
            production.setAuthor(newProduction.getAuthor());
            production.setTags(newProduction.getTags());
            production.setCasting(newProduction.getCasting());
            production.setDuration(newProduction.getDuration());
            production.setEpisodes(newProduction.getEpisodes());
            production.setFormat(newProduction.getFormat());
            production.setRating(newProduction.getRating());
            production.setReleaseDate(newProduction.getReleaseDate());
            production.setStatus(newProduction.getStatus());
            production.setSynopsis(newProduction.getSynopsis());

            productionRepository.save(production);

        }

    }

    public List<ProductionModel> listAll() {
        return productionRepository.findAll();
    }

    public Optional<ProductionModel> getProductionById(Integer id) {
        return productionRepository.findById(id);
    }

    public List<ProductionModel> search(String title) {
        if (title != null && !"".equals(title)) {
            return productionRepository.findByTitleContaining(title);

        }
        return productionRepository.findAll();
    }

    public List<ProductionModel> searchByTags(List<String> tags) {

        return productionRepository.findByTags(tags, (long) tags.size());

    }

    public List<ProductionModel> searchByInfo(String title, String author, String status, String format) {

        return productionRepository.findByInfo(title, author, status, format);

    }

    public List<ProductionModel> searchByCast(List<String> casting) {

        return productionRepository.findByCasting(casting, (long) casting.size());

    }

}
