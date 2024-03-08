package ru.cifrak.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.cifrak.news.model.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query("select n " +
            "from News as n " +
            "where n.id in :ids ")
    List<News> getAllNewsById(@Param("ids") List<Integer> ids);

    List<News> getAllNewsByTypeId(int newsType);
}
