package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Audit_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Be_pass;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Be_passRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Be_passServiceImpl  implements Be_passService {

    private final Be_passRepository be_passRepository;

    @Override
    public Be_pass findById(Long id) {
        return be_passRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Be_pass not found")
        );
    }

    @Override
    public List<Be_pass> findAllBe_pass() {
        return be_passRepository.findAll();
    }

    @Override
    public Be_pass saveBe_pass(Be_pass Be_pass) {
        return be_passRepository.save(Be_pass);
    }

    @Override
    public void deleteBe_passById(Long id) {
        be_passRepository.deleteById(id);
    }
}
