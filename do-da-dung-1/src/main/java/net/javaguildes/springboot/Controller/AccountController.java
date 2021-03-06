package net.javaguildes.springboot.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguildes.springboot.JWT.LoginRequest;
import net.javaguildes.springboot.Model.Account;
import net.javaguildes.springboot.Model.Response;
import net.javaguildes.springboot.Model.Role;
import net.javaguildes.springboot.Service.AccountService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/")
public class AccountController {
    @Autowired
    AccountService accSV;
    @GetMapping("/getAccs/pages={page}")
    Page<Account> getAllAccounts(@PathVariable int page){
        return accSV.getAllAccounts(page);
    }
    @PostMapping("/login")
    ResponseEntity<?> authenticateAccount(@Valid @RequestBody LoginRequest loginRequest){
        return accSV.authenticateAccount( loginRequest);
    }
    @PostMapping("/register")
    ResponseEntity<Response> registerAccount(@RequestBody Account newAcc){
        return accSV.registerAccount(newAcc);
    }
    @PutMapping("/changeAccInfo/{id}")
    ResponseEntity<Response> changeAccountInfo(@RequestBody Account updatedAcc,@PathVariable long id){
        return accSV.changeAccountInfo(updatedAcc,id);
    }
    @PreAuthorize("hasAuthority('admin') or hasAuthority('mod')")
    @PutMapping("/blockAcc/{id}")
    ResponseEntity<Response> block(@PathVariable long id){
        return accSV.block(id);
    }
    @PutMapping("/changeAccRole/{id}")
    ResponseEntity<Response> changeRole(@RequestBody Role updatedRole,@PathVariable long id){
        return accSV.changeRole(id,updatedRole);
    }
    @PutMapping("/changeAccPass/{id}")
    ResponseEntity<Response> changePass(@RequestBody Account updatedAcc,@PathVariable long id){
        return accSV.changePass(id,updatedAcc);
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/getAllRole")
    List<Role> getRole(){
        return accSV.getRole();
    }
    @GetMapping("/logoutsuccess")
    ResponseEntity<Response> getLogoutSuccess(){
        return accSV.getLogoutSuccess();
    }
}