package com.mdb.Animdb.model.services;

import com.mdb.Animdb.model.repositories.AdminRepository;
import com.mdb.Animdb.model.users.ADM;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public ADM save(ADM admin){
     return adminRepository.save(admin);
    };

    public void delete(Integer id){
        adminRepository.deleteById(id);
    }

    public void update(Integer id, ADM newAdmin){
        Optional<ADM> admOptional = adminRepository.findById(id);
        if(admOptional.isPresent()){
            ADM admin = admOptional.get();
            admin.setName(newAdmin.getName());
            admin.setEmail(newAdmin.getEmail());
            admin.setPassword(newAdmin.getPassword());
            adminRepository.save(admin);
        }

    }

    public List<ADM> listAll(){
        return adminRepository.findAll();
    }

    public Optional<ADM> getAdmin(Integer id){
        return adminRepository.findById(id);
    }

    public List<ADM> search(String nome){
        if(nome!=null && !"".equals(nome)){
            return adminRepository.findByNameContaining(nome);
        }
        return adminRepository.findAll();
    }
}
