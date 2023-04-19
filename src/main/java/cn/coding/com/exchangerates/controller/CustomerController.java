package cn.coding.com.exchangerates.controller;

import cn.coding.com.exchangerates.model.Customer;
import cn.coding.com.exchangerates.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String showCustomerList(Model model) {
        List<Customer> listCustomers = customerService.customerList();
        model.addAttribute("listCustomers", listCustomers);
        return "customer/customer_list";
    }


    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("pageTitle", "Add New Customer");
        return "customer/customer_form";
    }


    @PostMapping("/save")
    public String saveCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Customer Add Success.");
        return "redirect:/customer/list";
    }


    @GetMapping("/edit/{cid}")
    public String showEditForm(@PathVariable("cid") Long cid, Model model, RedirectAttributes redirect) {
        try {
            Customer customer = customerService.getByCid(cid);
            model.addAttribute("customer", customer);
            model.addAttribute("pageTitle", "Edit Customer (ID: " + cid + ")");
            return "customer/customer_form";
        } catch (Exception exc) {
            redirect.addFlashAttribute("message", exc.getMessage());
            return "redirect:/customer/list";
        }
    }


    @GetMapping("/delete/{cid}")
    public String deleteCustomer(@PathVariable("cid") Long cid, RedirectAttributes redirect) {
        try {
            customerService.deleteByCid(cid);
            redirect.addFlashAttribute("message", "Customer with ID " + cid + " has been Deleted!");
        } catch (Exception exc) {
            redirect.addFlashAttribute("message", exc.getMessage());
        }
        return "redirect:/customer/list";
    }
}
