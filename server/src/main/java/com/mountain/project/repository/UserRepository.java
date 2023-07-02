package com.mountain.project.repository;

import com.mountain.project.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findAllByFavouriteHotelsContains(HotelEntity hotel);
    List<UserEntity> findAllByFavouriteCottagesContains(CottageEntity cottage);
    List<UserEntity> findAllByFavouriteRoutesContains(RouteEntity route);
    List<UserEntity> findAllByFavouriteAttractionsContains(AttractionEntity attraction);

    @Query("SELECT hotel FROM UserEntity user JOIN user.favouriteHotels hotel WHERE user.id = :userId")
    List<HotelEntity> findAllFavouredHotelsByUserId(@Param("userId") Long userId);

    @Query("SELECT cottage FROM UserEntity user JOIN user.favouriteCottages cottage WHERE user.id = :userId")
    List<CottageEntity> findAllFavouredCottagesByUserId(@Param("userId") Long userId);

    @Query("SELECT route FROM UserEntity user JOIN user.favouriteRoutes route WHERE user.id = :userId")
    List<RouteEntity> findFavouriteRoutesByUserId(@Param("userId") Long userId);

    @Query("SELECT attraction FROM UserEntity user JOIN user.favouriteAttractions attraction WHERE user.id = :userId")
    List<AttractionEntity> findAllFavouredAttractionsByUserId(@Param("userId") Long userId);
}

