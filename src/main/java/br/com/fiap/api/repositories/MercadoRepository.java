package br.com.fiap.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.api.models.Mercado;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {
    
}

