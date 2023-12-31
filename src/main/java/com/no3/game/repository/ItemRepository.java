package com.no3.game.repository;

import com.no3.game.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long > {

    //페이징 처리 쿼리
    /*@Query("select i, avg(coalesce(r.grade,0)), count(distinct r) from Item i left outer join Review r on r.item = i group by i")
    Page<Object[]> getListPage(Pageable pageable);*/

    //i = Item  ii= ItemImg
    @Query("select i, ii, avg(coalesce(r.grade,0)),  count(r) from Item i " +
            "left outer join ItemImg ii on ii.item = i " +
            "left outer join Review  r on r.item = i group by i ")
    Page<Object[]> getListPage(Pageable pageable);


    @Query("select i, ii ,avg(coalesce(r.grade,0)),  count(r)" +
            " from Item i left outer join ItemImg ii on ii.item = i " +
            " left outer join Review  r on r.item = i "+
            " where i.id = :mno group by ii")
    List<Object[]> getMovieWithAll(Long mno);
}
