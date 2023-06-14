package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Product;
import net.skhu.model.Pagination;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

    public default List<Product> findAll(Pagination pagination) {
        Page<Product> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Product> findByCategoryId(int categoryId, Pageable pageable);

    Page<Product> findByTitleStartsWith(String Title, Pageable pageable);

    public default List<Product> findByCategoryTitle(Pagination pagination) {
        if (pagination.getDn().length()==0) return findAll(pagination);
        Page<Product> page = this.findByTitleStartsWith(pagination.getDn(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int) page.getTotalElements());
        return page.getContent();
    }

    List<Product> findByJumoonsCustomerId(int customerId);

}
