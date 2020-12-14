package com.mdb.Animdb.model.services;

import com.mdb.Animdb.model.objects.Casting;
import com.mdb.Animdb.model.objects.Tags;
import com.mdb.Animdb.model.repositories.CastingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CastingService {

    private final CastingRepository castingRepository;

    public CastingService(CastingRepository castingRepository) {
        this.castingRepository = castingRepository;
    }

   public Casting save(Casting cast){
        return castingRepository.save(cast);
   }

   public Casting add(Integer produtionId, String newCast){
        Casting cast = new Casting();
        cast.setProductionId(produtionId);
        cast.setActor(newCast);
        return castingRepository.save(cast);
   }

    public List<Casting> addMore(Integer productionId, List<String> casting){
        List<Casting> newCasting = new ArrayList<>();
        for (String cast: casting) {
            Casting newCast = new Casting();
            newCast.setProductionId(productionId);
            newCast.setActor(cast);
            castingRepository.save(newCast);
            newCasting.add(newCast);
        }
        return newCasting;
    }
    public void update(Integer id, Casting newCastMember){
        Optional<Casting> castingOptional = castingRepository.findById(id);
        if(castingOptional.isPresent()){
           Casting casting = castingOptional.get();
           casting.setActor(newCastMember.getActor());
           casting.setProductionId(newCastMember.getProductionId());
           castingRepository.save(casting);
        }
    }

   public void deleteById(Integer id){
        castingRepository.deleteById(id);
   }

   public List<Casting> getCastFromProductionId(Integer productionId){
        return castingRepository.findByProductionId(productionId);
   }

}
