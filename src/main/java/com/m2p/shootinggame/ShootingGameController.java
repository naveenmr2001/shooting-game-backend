package com.m2p.shootinggame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class ShootingGameController extends IllegalArgumentException {
    @Autowired
    private ShootingGameService shootingGameService;

    @GetMapping("/health")
    @ResponseBody
    public ResponseEntity<Integer> getHealth(@RequestParam String heroOrVillan) throws BadArgumentsException{

        if(heroOrVillan.equals("Hero")){
            return new ResponseEntity<>(shootingGameService.getHealth("Hero"),HttpStatus.OK);
        }else if(heroOrVillan.equals("Villan")){
            return new ResponseEntity<>(shootingGameService.getHealth("Villan"),HttpStatus.OK);
        }
        throw new BadArgumentsException("Bad Argument");

    }

    @PostMapping("/shoot")
    @ResponseBody
    @ResponseStatus(code= HttpStatus.CREATED)
    public void postDataOfShooting(@RequestParam String heroOrVillan){
        if(heroOrVillan.equals("Hero")){
            shootingGameService.postShooting("Hero");
        }else if(heroOrVillan.equals("Villan")){
            shootingGameService.postShooting("Villan");
        }
    }

    @PostMapping("/armor")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void setArmorOfVillan(Boolean trueOrFalse){

        shootingGameService.setArmourOfVillan(trueOrFalse);
    }
}
