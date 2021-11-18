package fr.li212.codingame.surfaces;

import fr.li212.codingame.surfaces.domain.models.GameInput;
import fr.li212.codingame.surfaces.domain.models.grid.Cell;
import fr.li212.codingame.surfaces.domain.models.grid.CellType;
import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;
import fr.li212.codingame.surfaces.domain.models.grid.Grid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestApplicationLotOfLake {

    private static final fr.li212.codingame.surfaces.domain.FindAllLakes FIND_ALL_LAKES = new fr.li212.codingame.surfaces.domain.FindAllLakes();

    private static final String GRID_STRING = generateGrid();

    private static final List<Coordinate> TO_FIND = generateCoordinatesToFind();

    public static void main(final String[] args) {
        final GameInput input = new GameInput(getGrid(), TO_FIND);
        FIND_ALL_LAKES.find(input).forEach(System.err::println);
    }

    private static Grid getGrid() {
        final String[] lines = TestApplicationLotOfLake.GRID_STRING.split("\n");
        final Cell[][] cells = new Cell[lines[0].length()][lines.length];

        for (int y = 0; y < lines.length; y++) {
            final char[] line = lines[y].toCharArray();
            for (int x = 0; x < line.length; x++) {
                cells[x][y] = new Cell(new Coordinate(x, y), line[x] == '#' ? CellType.LAND : CellType.WATER);
            }
        }
        return new Grid(cells);
    }

    private static String generateGrid() {
        final StringBuilder result = new StringBuilder();
        for (int y = 0; y < 1000; y++) {
            for (int x = 0; x < 1000; x++) {
                if (y % 10 == 0) {
                    result.append("#");
                } else if (x > 10 && x < 20) {
                    result.append("o");
                } else {
                    result.append("#");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    private static List<Coordinate> generateCoordinatesToFind() {
        return IntStream.range(0, 100).boxed().map(current -> new Coordinate(15, current * 10 + 1)).collect(Collectors.toList());
    }

}
