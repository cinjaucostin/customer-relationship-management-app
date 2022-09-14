package com.costin.crmapp.controller;

import com.costin.crmapp.dao.CustomerDAO;
import com.costin.crmapp.entity.Customer;
import com.costin.crmapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> customers = customerService.getCustomers();

        theModel.addAttribute("customers", customers);

        System.out.println(customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddCustomer(Model theModel) {

//        Create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute(
                "customer",
                theCustomer
        );

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchedName") String theName,
                                  Model theModel) {

        List<Customer> searchedCustomers = customerService.searchCustomers(theName);

        theModel.addAttribute("customers", searchedCustomers);

        return "list-customers";
    }

}
