package com.m2p.shootinggame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShootingGameController {
    @Autowired
    private ShootingGameService shootingGameService;

    @GetMapping("/health")
    @ResponseBody
    public int getHealth(@RequestParam String heroOrVillan){
        if(heroOrVillan.equals("Hero")){
            return shootingGameService.getHealth("Hero");
        }else if(heroOrVillan.equals("Villan")){
            return shootingGameService.getHealth("Villan");
        }
        return 0;
    }

    @PostMapping("/shoot")
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public String postDataOfShooting(@RequestParam String heroOrVillan){
        if(heroOrVillan.equals("Hero")){
            return shootingGameService.postShooting("Hero");
        }else if(heroOrVillan.equals("Villan")){
            return shootingGameService.postShooting("Villan");
        }
        return "Error";
    }

    @PostMapping("/armor")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void setArmorOfVillan(){
        shootingGameService.setArmorOfVillan();
    }
}
