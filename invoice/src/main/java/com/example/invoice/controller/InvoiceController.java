package com.example.invoice.controller;

import com.example.invoice.dto.InvoiceDTO;
import com.example.invoice.entity.InvoiceEntity;
import com.example.invoice.service.InvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public ResponseEntity<List<InvoiceEntity>> getAllInvoice(){
        return new ResponseEntity<List<InvoiceEntity>>(invoiceService.getAllInvoice(), HttpStatus.OK);
    }

    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable long id){
        InvoiceEntity invoiceEntity =invoiceService.getInvoiceById(id);
        return ResponseEntity.ok().body(modelMapper.map(invoiceEntity, InvoiceDTO.class));
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    public ResponseEntity<InvoiceEntity> createInvoice(@RequestBody InvoiceDTO invoiceDTO) throws JsonProcessingException {
        InvoiceEntity invoiceEntity =  modelMapper.map(invoiceDTO, InvoiceEntity.class);
        return ResponseEntity.ok().body(this.invoiceService.createInVoice(invoiceEntity));
    }

    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.PUT)
    public ResponseEntity<InvoiceEntity> updateInvoice(@PathVariable long id, @RequestBody InvoiceEntity invoiceEntity){
        invoiceEntity.setId(id);
        return ResponseEntity.ok().body(this.invoiceService.updateInvoice(invoiceEntity));
    }

    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteInvoice(@PathVariable long id){
        this.invoiceService.deleteInvoice(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

//    @Autowired
//    public UserApi userApi;
//
//    @GetMapping(path = "/callUser")
//    public List callUser() {
//        List listUser = userApi.getAllUser();
//        return listUser;
//    }
}
