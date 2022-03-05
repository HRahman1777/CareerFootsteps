package com.hasibur.CareerFootsteps.service.tag;

import com.hasibur.CareerFootsteps.model.Tag;
import com.hasibur.CareerFootsteps.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImp implements TagService{

    @Autowired
    TagRepo tagRepo;

    @Override
    public Tag addTag(Tag tag) {
        return tagRepo.save(tag);
    }
}
