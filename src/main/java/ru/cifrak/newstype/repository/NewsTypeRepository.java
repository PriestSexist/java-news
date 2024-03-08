package ru.cifrak.newstype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.cifrak.newstype.model.NewsType;

import java.util.List;

@Repository
public interface NewsTypeRepository extends JpaRepository<NewsType, Integer> {
    @Query("select nt " +
            "from NewsType as nt " +
            "where nt.id in :ids ")
    List<NewsType> getAllNewsTypeById(@Param("ids") List<Integer> ids);
}
