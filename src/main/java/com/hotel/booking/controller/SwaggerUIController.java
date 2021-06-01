package com.hotel.booking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SwaggerUIController {

   @RequestMapping(value = "/swagger")
   public String getSwagger(){
       return "redirect:swagger-ui.html";
   }
}
