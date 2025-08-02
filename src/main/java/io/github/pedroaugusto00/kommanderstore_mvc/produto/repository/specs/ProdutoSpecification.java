package io.github.pedroaugusto00.kommanderstore_mvc.produto.repository.specs;

import org.springframework.data.jpa.domain.Specification;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Produto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoSpecification {

    public static Specification<Produto> filtrar(
            String nome,
            String descricao,
            UUID categoriaId,
            BigDecimal precoMin,
            BigDecimal precoMax
    ) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (nome != null && !nome.isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
            }

            if (descricao != null && !descricao.isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("descricao")), "%" + descricao.toLowerCase() + "%"));
            }

            if (categoriaId != null) {
                predicates = cb.and(predicates, cb.equal(root.get("categoria").get("id"), categoriaId));
            }

            if (precoMin != null) {
                predicates = cb.and(predicates, cb.greaterThanOrEqualTo(root.get("preco"), precoMin));
            }

            if (precoMax != null) {
                predicates = cb.and(predicates, cb.lessThanOrEqualTo(root.get("preco"), precoMax));
            }

            return predicates;
        };
    }
}
