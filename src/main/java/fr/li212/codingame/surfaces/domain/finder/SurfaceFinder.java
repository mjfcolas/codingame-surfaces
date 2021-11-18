package fr.li212.codingame.surfaces.domain.finder;

import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;

import java.util.Set;

public interface SurfaceFinder {
    Set<Coordinate> findSurface(final Coordinate germ);
}
