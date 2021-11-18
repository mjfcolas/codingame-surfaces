package fr.li212.codingame.surfaces.domain;

import fr.li212.codingame.surfaces.domain.finder.SurfaceFinder;
import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;

public class FindOneLake {

    final SurfaceFinder surfaceFinder;

    public FindOneLake(final SurfaceFinder surfaceFinder) {
        this.surfaceFinder = surfaceFinder;
    }

    public Integer find(final Coordinate coordinate) {
        return this.surfaceFinder.findSurface(coordinate).size();
    }
}
