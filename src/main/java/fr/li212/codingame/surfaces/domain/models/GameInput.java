package fr.li212.codingame.surfaces.domain.models;

import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;
import fr.li212.codingame.surfaces.domain.models.grid.Grid;

import java.util.Collection;

public class GameInput {
    final Grid grid;
    final Collection<Coordinate> coordinatesToTest;

    public GameInput(final Grid grid, final Collection<Coordinate> coordinatesToTest) {
        this.grid = grid;
        this.coordinatesToTest = coordinatesToTest;
    }

    public Grid getGrid() {
        return grid;
    }

    public Collection<Coordinate> getCoordinatesToTest() {
        return coordinatesToTest;
    }
}
