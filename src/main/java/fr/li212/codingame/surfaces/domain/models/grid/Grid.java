package fr.li212.codingame.surfaces.domain.models.grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int width;
    private final int height;
    private final Cell[][] cells;
    private final ArrayList[][] neighboursCache;


    public Grid(final Cell[][] cells) {
        this.height = cells[0].length;
        this.width = cells.length;
        this.cells = cells;
        neighboursCache = new ArrayList[width][height];
    }

    public List<Coordinate> getNeighbours(final Coordinate coordinate) {
        if (neighboursCache[coordinate.getX()][coordinate.getY()] != null) {
            return neighboursCache[coordinate.getX()][coordinate.getY()];
        }
        final ArrayList<Coordinate> result = new ArrayList<>(4);
        if (coordinate.getX() - 1 >= 0) {
            if (cells[coordinate.getX() - 1][coordinate.getY()].isWater()) {
                result.add(cells[coordinate.getX() - 1][coordinate.getY()].getCoordinate());
            }
        }
        if (coordinate.getX() + 1 < width) {
            if (cells[coordinate.getX() + 1][coordinate.getY()].isWater()) {
                result.add(cells[coordinate.getX() + 1][coordinate.getY()].getCoordinate());
            }
        }
        if (coordinate.getY() - 1 >= 0) {
            if (cells[coordinate.getX()][coordinate.getY() - 1].isWater()) {
                result.add(cells[coordinate.getX()][coordinate.getY() - 1].getCoordinate());
            }
        }
        if (coordinate.getY() + 1 < height) {
            if (cells[coordinate.getX()][coordinate.getY() + 1].isWater()) {
                result.add(cells[coordinate.getX()][coordinate.getY() + 1].getCoordinate());
            }
        }
        neighboursCache[coordinate.getX()][coordinate.getY()] = result;
        return result;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(final Coordinate coordinate) {
        return cells[coordinate.getX()][coordinate.getY()];
    }
}
