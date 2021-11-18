package fr.li212.codingame.surfaces.domain.models.grid;

import java.util.Objects;

public class Cell {
    private final Coordinate coordinate;
    private final CellType cellType;

    public Cell(final Coordinate coordinate, final CellType cellType) {
        this.coordinate = coordinate;
        this.cellType = cellType;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isWater() {
        return CellType.WATER.equals(cellType);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Cell cell = (Cell) o;
        return Objects.equals(coordinate, cell.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
