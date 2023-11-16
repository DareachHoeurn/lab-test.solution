package lego;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Comparator;
import java.util.Set;
import java.util.logging.Level;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
//@Setter
@ToString

public class LegoSet {
    public static final Minifigure.LegoSetComparator COMPARATOR = new Minifigure.LegoSetComparator();
    private String code;
    private String name;

    @EqualsAndHashCode.Exclude
//    private String theme;
    private int bricks;
    @ToString.Exclude
    private Set<Minifigure> minifigures;

//    ==============

    @NoArgsConstructor(access =  AccessLevel.PRIVATE,force = true)
    @AllArgsConstructor
    @Getter
    @ToString
    public static class Minifigure{
    private String name;
    private String id;
    private int quantity;

//    =================
    public static enum Theme{
        @JsonProperty("City") CITY,

        @JsonProperty("Harry Potter") HARRY_POTTER,
        @JsonProperty("Star War") START_WARS,
        @JsonProperty("Creator Expert") CREATOR_EXPERT
    }
    public static class LegoSetComparator implements Comparator<LegoSet>{
        @Override
        public int compare(LegoSet o1, LegoSet o2) {
            if(o1.bricks != o2.bricks){
//                descanding order
                return -Integer.compare(o1.bricks, o2.bricks);
            }
        }
            return 0;
        }
    }

}
==============
package lego;

import base.Queries;
import base.Repository;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LegoSetRepository extends Repository<LegoSet> implements Queries<LegoSet,LegoSet.Minifigure> {

    @SneakyThrows

    public LegoSetRepository(){
        super(LegoSet.class);
    }

    @SneakyThrows
    public static void main(String[] args){
        LegoSetRepository repo = new LegoSetRepository();
        System.out.println(repo);
    }

    @Override
    public int getMaximumOfPieces() {
        int max = getAll().get(0).getBricks();
        for (int i = 1; i < countries.size(); i++) {
            if (LegoSet.get(i).getPopulation() > max) {
                max = countries.get(i).getPopulation();
            }
        }
        return max;
    }

    @Override
    public List<LegoSet> getSetsOrderByCountOfBricksDescThenByNumber() {
        return null;
    }

    @Override
    public Set<String> getNamesOfSetsByTheme(@NonNull Enum theme) {
        return null;
    }

    @Override
    public Map getThemesByCodes() {
        return null;
    }

    @Override
    public Map<Integer, Set<LegoSet>> getSetsByPieces() {
        return null;
    }
}
