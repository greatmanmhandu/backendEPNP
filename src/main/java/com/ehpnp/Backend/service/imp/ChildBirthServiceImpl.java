package com.ehpnp.Backend.service.imp;
import com.ehpnp.Backend.model.ChildBirth;
import com.ehpnp.Backend.repository.ChildBirthRepository;
import com.ehpnp.Backend.service.ChildBirthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildBirthServiceImpl implements ChildBirthService {

    @Autowired
    ChildBirthRepository childBirthRepository;


    @Override
    public ChildBirth create(ChildBirth childBirth) {
        return childBirthRepository.save(childBirth);
    }

    @Override
    public  List<ChildBirth> getAll() {
        return childBirthRepository.findAll();
    }

    @Override
    public ChildBirth getChildBirthById(Long id) {
        Optional<ChildBirth> childBirth = childBirthRepository.findById(id);
        return childBirth.get();
    }

    @Override
    public ChildBirth updateCenter(Long id, ChildBirth childBirth) {
        Optional<ChildBirth> centerOptional = childBirthRepository.findById(id);

        centerOptional.get().setName(childBirth.getName());
        centerOptional.get().setAddress(childBirth.getAddress());
        centerOptional.get().setCity(childBirth.getCity());

        ChildBirth save = childBirthRepository.save(centerOptional.get());
        return getChildBirthById(save.getId());
    }
}
