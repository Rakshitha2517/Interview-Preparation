package org.example.electricitybill.Controller;

import org.example.electricitybill.Entity.Admin;
import org.example.electricitybill.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService service;
    //dispaly admin
    @GetMapping("/admin")
    public List<Admin> getAdmin() {
        return service.getAllAdmin();
    }
    //add admin
    @PostMapping("/admin")
    public Admin addAdmin(@RequestBody Admin a) {
        return service.saveAdmin(a);
    }
    //update admin details
    @PutMapping("/admin/{id}")
    public Admin update(@PathVariable int id, @RequestBody Admin a) {
        return service.updateAdmin(id, a);
    }
    // delete admim
    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteAdmin(id);
    }
}
