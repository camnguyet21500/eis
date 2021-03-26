//package com.example.invoice.service;
//
//import com.example.invoice.DTO.InvoiceTypeDTO;
//import com.example.invoice.entity.InvoiceEntity;
//import com.example.invoice.repository.InvoiceRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class MapService {
//    @Autowired
//    private InvoiceRepository invoiceRepository;
//
//    public List<InvoiceTypeDTO> getAllInvoicesType(){
//        return ((List<InvoiceEntity>) invoiceRepository
//                .findAll())
//                .stream()
//                .map(this::convertToInvoiceTypeDTO)
//                .collect(Collectors.toList());
//    }
//
//        private InvoiceTypeDTO convertToUserLocationDTO(InvoiceEntity invoiceEntity) {
//            InvoiceTypeDTO invoiceTypeDTO = new InvoiceTypeDTO();
//            invoiceTypeDTO.set(user.getId());
////        userLocationDTO.setUsername(user.getUsername());
////        Location location = user.getLocation();
////        userLocationDTO.setLat(location.getLat());
////        userLocationDTO.setLng(location.getLng());
////        userLocationDTO.setPlace(location.getPlace());
////        return userLocationDTO;
//
//}
//
//
//
//
