package com.mdb.Animdb.model.services;

import com.mdb.Animdb.model.objects.Tags;
import com.mdb.Animdb.model.repositories.TagsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagsService {

    private final TagsRepository tagsRepository;

    public TagsService(TagsRepository tagsRepository){
        this.tagsRepository = tagsRepository;
    }

    public Tags save(Tags tag){
        return tagsRepository.save(tag);
    }

    public Tags add(Integer productionId, String tag){
        Tags newTag = new Tags();
        newTag.setProductionId(productionId);
        newTag.setValue(tag);
        return tagsRepository.save(newTag);

    }

    public List<Tags> addMore(Integer productionId, List<String> tags){
        List<Tags> newTags = new ArrayList<>();
        for (String tag: tags) {
            Tags newTag = new Tags();
            newTag.setProductionId(productionId);
            newTag.setValue(tag);
            tagsRepository.save(newTag);
            newTags.add(newTag);
        }
        return newTags;
    }

    public void deleteById(Integer tagId){
        tagsRepository.deleteById(tagId);
    }

    public void deleteByProductionIdAndName(Integer productionId, String value){
        Tags tag = tagsRepository.getByProductionIdAndValue(productionId,value);
        tagsRepository.delete(tag);
    }
}
