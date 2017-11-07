package com.infosupport.minor.rabbit_mq_restaurant_app.controller;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController {

    @Autowired
    private RestTemplate restTemplate;
    private List<Dish> dishes;

    @GetMapping(value = "/")
    public String getDishes(Model model) {
        // MS2 getDishes()
        ResponseEntity<List<Dish>> dishReponse = restTemplate.exchange("http://127.0.0.1:8081/dishes", HttpMethod.GET, null, new ParameterizedTypeReference<List<Dish>>() {});
        System.out.println(dishReponse.getBody());
        model.addAttribute("dishes", dishReponse.getBody());

        return "dish/dish_overview";
    }

    @PostMapping(value = "/order")
    public String placeOrder(@RequestParam("selectedDishes") String[] selectedDishes) {
        // MS1 placeOrder()
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String[]> request = new HttpEntity<String[]>(selectedDishes);
        restTemplate.postForEntity( "http://127.0.0.1:8082/order", request , null);

        return "redirect:/";
    }

}
