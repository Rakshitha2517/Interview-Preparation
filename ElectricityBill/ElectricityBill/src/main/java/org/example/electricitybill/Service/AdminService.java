package org.example.electricitybill.Service;

import org.example.electricitybill.Entity.Admin;
import org.example.electricitybill.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public Admin saveAdmin(Admin a) {
        return repo.save(a);
    }

    public List<Admin> getAllAdmin() {
        return repo.findAll();
    }

    public String deleteAdmin(int id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    public Admin updateAdmin(int id, Admin a) {
        Admin existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setAdminName(a.getAdminName());
            existing.setUsername(a.getUsername());
            existing.setPassword(a.getPassword());
            return repo.save(existing);
        }

        return null;
    }
}