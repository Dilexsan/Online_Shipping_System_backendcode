package com.onlineshipping.backend.controller;

import com.onlineshipping.backend.exception.DetailNotFoundException;
import com.onlineshipping.backend.model.Detail;
import com.onlineshipping.backend.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class DetailController {

    @Autowired
    private DetailRepository detailRepository;

    @PostMapping("/detail")
    Detail newDetail(@RequestBody Detail newDetail){

        return detailRepository.save(newDetail);
    }

    @GetMapping("/details")
    List<Detail> getAllDetail(){

        return detailRepository.findAll();
    }

    @GetMapping("/detail/{id}")
    Detail getDetailById(@PathVariable Long id){

        return detailRepository.findById(id)
                .orElseThrow(()->new DetailNotFoundException(id));
    }

    @PutMapping("/detail/{id}")
    Detail updateDetails(@RequestBody Detail newDetail,@PathVariable Long id){
        return detailRepository.findById(id)
                .map(detail->{
                    detail.setName(newDetail.getName());
                    detail.setArea(newDetail.getArea());
                    detail.setAmount(newDetail.getAmount());
                    detail.setLocation(newDetail.getLocation());
                    detail.setPhone(newDetail.getPhone());

                    return detailRepository.save(detail);
                }).orElseThrow(()->new DetailNotFoundException(id));

    }

    @DeleteMapping("/detail/{id}")
    String deleteDetails(@PathVariable Long id){
        if(!detailRepository.existsById(id)){
            throw new DetailNotFoundException(id);
        }
        detailRepository.deleteById(id);
        return "Details with id "+id+ "has been deleted success.";
    }

}
